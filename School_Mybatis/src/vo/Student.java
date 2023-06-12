package vo;

public class Student extends Person {
	
	private int seq_student;
	private String stdno;
	
	public Student () {
		
	}
	
	public int getSeq_student() {
		return seq_student;
	}

	public void setSeq_student(int seq_student) {
		this.seq_student = seq_student;
	}

	public String getStdno() {
		return stdno;
	}

	public void setStdno(String stdno) {
		this.stdno = stdno;
	}
	
	public Student (String name, String ssn, int age, String type, String stdno) {
		super(name, ssn, age, type);
		this.stdno = stdno;
	}

	@Override
	public String toString() {
		return super.toString() + " Student [seq_student = " + seq_student + ", stdno = " + stdno + " S]";
	}
	
	
	
	

}








