package multi.erp.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpDAO dao;
	
	@Override
	public int insert(EmpVO user) {
		System.out.println("서비스단 insert => dao의 insert를 호출하며 매개변수로 넘어온 객체 전달:"+user);
		dao.insert(user);
		return 0;
	}

	@Override
	public List<EmpVO> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public boolean idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public EmpVO login(EmpVO loginUser) {
		return dao.login(loginUser);
	}

}
