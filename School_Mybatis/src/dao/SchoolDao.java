package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Person;
import vo.Staff;
import vo.Student;
import vo.Teacher;

public class SchoolDao {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 학생 등록

	public boolean addStudent(Student student) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			mapper.addPerson(student);
			Person person = mapper.findPersonBySsn(student.getSsn());
			student.setSeq_person(person.getSeq_person());

			System.out.println(student);
			mapper.addStudent(student);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 교사 등록
	public boolean addTeacher(Teacher teacher) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			mapper.addPerson(teacher);
			Person person = mapper.findPersonBySsn(teacher.getSsn());
			teacher.setSeq_person(person.getSeq_person());
			mapper.addTeacher(teacher);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 직원 등록

	public boolean addStaff(Staff staff) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			mapper.addPerson(staff);
			Person person = mapper.findPersonBySsn(staff.getSsn());
			staff.setSeq_person(person.getSeq_person());
			mapper.addStaff(staff);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 모든 회원정보 검색
	public List<Person> findAllPersons() {
		List<Person> result = new ArrayList<>();
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			result.addAll(mapper.findAllStudent(null));
			result.addAll(mapper.findAllTeacher(null));
			result.addAll(mapper.findAllStaff(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 주민번호로 검색

	public Person findPersonBySsn(String ssn) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			Person person = mapper.findPersonBySsn(ssn);
			if (person == null) return null;
			switch (person.getType()) {
			case "STUDENT":
				List<Student> students = mapper.findAllStudent(ssn);
				if (students.size() > 0) {
					return students.get(0);
				}
				break;
			case "TEACHER":
				return mapper.findTeacher(ssn);
			case "STAFF" :
				return mapper.findStaff(ssn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 회원정보 수정
	public boolean updatePerson (Person person) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			// 주민번호로 Person 객체 찾아오기
			Person findPerson = mapper.findPersonBySsn(person.getSsn());
			if (findPerson != null) {
				person.setSeq_person(findPerson.getSeq_person());
				mapper.updatePerson(person);
				switch (findPerson.getType()) {
				case "STUDENT": mapper.updateStudent((Student) person); break;
				case "TEACHER": mapper.updateTeacher((Teacher) person); break; 
				case "STAFF": mapper.updateStaff((Staff) person); break;
				}
				session.commit();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 회원정보 삭제
	
	public boolean removePerson (String ssn) {
		try (SqlSession session = factory.openSession()) {
			SchoolMapper mapper = session.getMapper(SchoolMapper.class);
			Person findPerson = mapper.findPersonBySsn(ssn);
			if (findPerson != null) {
				switch (findPerson.getType()) {
				case "STUDENT": mapper.removeStudent(findPerson); break;
				case "TEACHER": mapper.removeTeacher(findPerson); break; 
				case "STAFF": mapper.removeStaff(findPerson); break;
				}
				mapper.removePerson(findPerson);
				session.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
