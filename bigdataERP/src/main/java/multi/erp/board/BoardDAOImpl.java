package multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public BoardVO read(String board_no) {
		//sql실행결과가 레코드 하나 인 경우
		return sqlSession.selectOne("erp.board.read", board_no);
	}
	@Override
	public List<BoardVO> boardList() { //전체목록조회
		return sqlSession.selectList("erp.board.list");
	}

	@Override
	public int insert(BoardVO board) {
		int result = sqlSession.insert("erp.board.insert", board);
		return result;
	}

	@Override
	public List<BoardVO> searchList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		//SqlSession의 여러 메소드를 호출하면서 VO객체, 문자열, Map등에 데이터를 저장해서 전달할 수 있다.
		Map<String,String> map = new HashMap<String,String>();
		map.put("tag",tag);
		map.put("search",search);
		return sqlSession.selectList("erp.board.dynamicsql", map);
	}

	@Override
	public List<BoardVO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return 0;
	}
	//게시글에서 카테고리별로 검색하기 위한 메소드
	@Override
	public List<BoardVO> categorySearch(String category) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("erp.board.category", category);
	}

}
