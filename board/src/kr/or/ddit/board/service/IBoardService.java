package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	
	/**
	 * 전체 리스트 가져 오기
	 * @return
	 */
	public List<BoardVO> selectAll();

	/**
	 * 페이지별 리스트 가져오기
	 */
	public List<BoardVO> selectPage(Map<String, Integer> map);
	
	/**
	 * 전체 글 갯수 가져오기
	 */
	public int getTotalCount();
	
	// 댓글 저장
	public int replySave(ReplyVO vo);
	
	// 댓글 리스트
	public List<ReplyVO> replyList(int bonum);
	
	// 댓글 수정
	public int replyUpdate(ReplyVO vo); 
	
	// 댓글 삭제
	public int replyDelete(int renum);
	
	// 게시글 삭제
	public int deleteBoard(int seq);
	
	// 게시글 저장
	public int insertBoard(BoardVO vo);
	
	// 수정할 게시글 조회하기
	public BoardVO updateSelect(int seq);
	
	// 게시글 수정
	public int updateBoard(BoardVO vo);
	
}
