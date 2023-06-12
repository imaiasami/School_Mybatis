package manager;

import java.util.*;

import dao.SchoolDao;

import java.io.*;

import exception.DuplicateSsnException;
import exception.PersonNotFoundException;
import vo.*;

public class SchoolManager {
	
	private SchoolDao dao;

	public SchoolManager() {
		dao = new SchoolDao();
		
	}
	
	public Person addPerson(Person p) throws DuplicateSsnException {
		switch (p.getType()) {
		case "STUDENT" : dao.addStudent((Student) p) ; break;
		case "TEACHER" : dao.addTeacher((Teacher) p) ; break;
		case "STAFF" : dao.addStaff((Staff) p) ; break;
		}
		
		return null;
}
	
	public Person findPerson(String ssn) throws PersonNotFoundException {
		Person person = dao.findPersonBySsn(ssn);
		if (person == null)	throw new PersonNotFoundException(ssn);
		return person;
	}
	
	public boolean updatePerson (Person person) {
		return dao.updatePerson(person);
	}
	
	public boolean removePerson(String ssn) {
		return dao.removePerson(ssn);
		}

	public List<Person> findAllPersons() {
		return dao.findAllPersons();
	}

	
}