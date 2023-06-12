package dao;

import java.util.List;

import vo.Person;
import vo.Staff;
import vo.Student;
import vo.Teacher;

public interface SchoolMapper {
	
	int addPerson (Person person);
	int addStudent (Student student);
	int addTeacher (Teacher teacher);
	int addStaff (Staff staff);
	
	Person findPersonBySsn(String ssn);
	List<Student> findAllStudent (String ssn);
	List<Teacher> findAllTeacher (String ssn);
	List<Staff> findAllStaff (String ssn);
	Teacher findTeacher (String ssn);
	Staff findStaff (String ssn);
	
	int updatePerson (Person person);
	int updateStudent (Student student);
	int updateTeacher (Teacher teacher);
	int updateStaff (Staff staff);
	
	int removeStudent (Person person);
	int removeTeacher (Person person);
	int removeStaff (Person person);
	int removePerson (Person person);
	
	
	
}
