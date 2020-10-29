package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {

	private SqlMapClient client;
	private static IBoardDao dao;
	
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}
	
	public static IBoardDao getDao() {
		if (dao == null) dao = new BoardDaoImpl();
			
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return client.queryForList("board.selectAll");
	}

	@Override
	public List<BoardVO> selectPage(Map<String, Integer> map) throws SQLException {
		
		return client.queryForList("board.selectPage", map);
	}

	@Override
	public int getTotalCount() throws SQLException {
	
		return (Integer) client.queryForObject("board.getTotalCount");
	}

	@Override
	public int replySave(ReplyVO vo) throws SQLException {
		return (Integer) client.insert("reply.replySave", vo);
	}

	@Override
	public List<ReplyVO> replyList(int bonum) throws SQLException {
		return client.queryForList("reply.replyList", bonum);
	}

	@Override
	public int replyUpdate(ReplyVO vo) throws SQLException {
		return client.update("reply.replyUpdate", vo);
	}

	@Override
	public int replyDelete(int renum) throws SQLException {
		return client.delete("reply.replyDelete", renum);
		
		
	}

	@Override
	public int deleteBoard(int seq) throws SQLException {
		return client.delete("board.deleteBoard", seq);
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (Integer) client.insert("board.insertBoard", vo);
	}

	@Override
	public BoardVO updateSelect(int seq) throws SQLException {
		return (BoardVO) client.queryForObject("board.updateSelect", seq);
	}

	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		return client.update("board.updateBoard", vo);
	}

	
}
