package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
	
	/**
	 * 전체 리스트 가져 오기
	 * @return
	 */
	public List<BoardVO> selectAll() throws SQLException;
	
	
	/**
	 * 페이지별 리스트 가져오기
	 */
	public List<BoardVO> selectPage(Map<String, Integer> map) throws SQLException;
	
	/**
	 * 전체 글 갯수 가져오기
	 */
	public int getTotalCount() throws SQLException;
	
	// 댓글 저장
	public int replySave(ReplyVO vo) throws SQLException;
		
	// 댓글 리스트
	public List<ReplyVO> replyList(int bonum) throws SQLException;
	
	// 댓글 수정
	public int replyUpdate(ReplyVO vo) throws SQLException; 
	
	// 댓글 삭제
	public int replyDelete(int renum) throws SQLException;
	
	// 게시글 삭제
	public int deleteBoard(int seq) throws SQLException;
	
	// 게시글 저장
	public int insertBoard(BoardVO vo) throws SQLException;
	
	// 수정할 게시글 조회하기
	public BoardVO updateSelect(int seq) throws SQLException;
		
	// 게시글 수정
	public int updateBoard(BoardVO vo) throws SQLException;
	
	
}
