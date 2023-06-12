package vo;

public class Staff extends Person {
	private int seq_staff;
	private String dept;		// 부서 정보
	
	public Staff() {
		
	}
	
	public Staff(String name, String ssn, int age, String type, String dept) {
		super(name, ssn, age, type);
		this.dept = dept;
	}

	public int getSeq_staff() {
		return seq_staff;
	}

	public void setSeq_staff(int seq_staff) {
		this.seq_staff = seq_staff;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + "Staff [seq_staff = " + seq_staff + ", dept = " + dept + " ]";
	}
	
	
	
	
	
	

}
