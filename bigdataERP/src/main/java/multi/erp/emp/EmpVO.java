package multi.erp.emp;

public class EmpVO {
	private String id; 
	private String pass;
	private String name;
	private String addr;
	private int point;
	private String deptno;
	private String img;
	private String info;
	public EmpVO() {
		System.out.println("EmpVo의 기본생성자");
	}

	//login용
	public EmpVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	//insert용
	public EmpVO(String id, String pass, String name, String addr, String deptno) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.deptno = deptno;
	
	}

	//select용
	public EmpVO(String id, String pass, String name, String addr, int point, String deptno,String img) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.point = point;
		this.deptno = deptno;
		this.img = img;
	}
	public EmpVO(String id, String pass, String name, String addr, int point, String deptno) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.point = point;
		this.deptno = deptno;
	}
	
	public EmpVO(String id, String pass, String name, String addr, int point, String deptno, String img, String info) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.point = point;
		this.deptno = deptno;
		this.img = img;
		this.info = info;
	}

	

	@Override
	public String toString() {
		return "EmpVO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", point=" + point
				+ ", deptno=" + deptno + ", img=" + img + ", info=" + info + "]";
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getId() {
		System.out.println("getId++++++++++++++++");
		return id;
	}
	public void setId(String id) {
		System.out.println("setId++++++++++++++++++");
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
