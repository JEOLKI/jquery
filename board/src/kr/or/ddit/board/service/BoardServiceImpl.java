package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService{
	
	private IBoardDao dao;
	
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getService() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> selectPage(Map<String, Integer> map) {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int getTotalCount() {
		int count = 0;
		
		try {
			count = dao.getTotalCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int replySave(ReplyVO vo) {
		int renum = 0;
		try {
			renum = dao.replySave(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return renum;
	}

	@Override
	public List<ReplyVO> replyList(int bonum) {
		List<ReplyVO> list = null;
		
		try {
			list = dao.replyList(bonum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.replyUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int replyDelete(int renum) {

		int cnt = 0;
		
		try {
			cnt = dao.replyDelete(renum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int deleteBoard(int seq) {
		
		int cnt = 0;
		
		try {
			cnt = dao.deleteBoard(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int seq = 0;
		
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seq;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public BoardVO updateSelect(int seq) {
		BoardVO vo = null;
		
		try {
			vo = dao.updateSelect(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
