package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	
	public List<MemberVO> selectAll();
	
	/**
	 *  중복검사
	 * @param mem_id
	 * @return
	 */
	public String checkById(String mem_id);

	/**
	 *  우편번호 검색
	 * @param dong
	 * @return
	 */
	public List<ZipVO> selectByDong(String dong);

	/**
	 *  가입하기
	 * @param member
	 * @return
	 */
	public String insertMember(MemberVO member);
	
}
