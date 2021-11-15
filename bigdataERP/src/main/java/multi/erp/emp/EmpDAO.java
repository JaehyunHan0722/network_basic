package multi.erp.emp;

import java.util.List;

public interface EmpDAO {
	int insert(EmpVO user);
	List<EmpVO> getMemberList();
	boolean idCheck(String id);
	EmpVO login(EmpVO loginUser);
}
