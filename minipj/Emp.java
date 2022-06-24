package minipj;

public class Emp {
	//필드 선언 오라클 테이블 empinfo 에서 가져올 정보 : 사번, 이름, 입사일, 직무, 이메일)
	int empId;
	String name;
	String hireDate;
	String jobId;
	String email;
	
	//생성자 만들기
	public Emp(int empId) {
		this.empId=empId;
	}
	public Emp(int empId, String name, String hireDate, String jobId, String email) {
		this.empId=empId;
		this.name=name;
		this.hireDate=hireDate;
		this.jobId=jobId;
		this.email=email;
	}
}
