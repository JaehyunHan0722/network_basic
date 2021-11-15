package multi.erp.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//MyBatis에서 제공하는 기능을 이용해서 DB 액세스 - CLRUD처리
@Repository
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public int insert(EmpVO user) {
		System.out.println("member테이블에 insert:"+user);
		sqlSession.insert("erp.emp.insert", user);
		return 0;
	}

	@Override
	public List<EmpVO> getMemberList() {
		return  sqlSession.selectList("erp.emp.list");
	}

	@Override
	public boolean idCheck(String id) {
		boolean result = false;
		//primary key를 비교하는 sql문은 결과가 레코드 하나
		//=> SqlSession의 메소드 => selectOne
		EmpVO user = sqlSession.selectOne("erp.emp.idcheck", id);
		if(user!=null) {
			result = true;//아이디가 있으면 true
		}
		return result; //아이디가 없으면 false 
	}

	@Override
	public EmpVO login(EmpVO loginUser) {
		System.out.println("loginUser=>"+loginUser);
		EmpVO loginOkUser = sqlSession.selectOne("erp.emp.login", loginUser);
		System.out.println("결과=>"+loginOkUser);
		return loginOkUser;
	}

}




