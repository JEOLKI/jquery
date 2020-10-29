package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {
	
	public List<MemberVO> selectAll() throws SQLException;
	
	
	/**
	 *  중복검사
	 * @param mem_id
	 * @return
	 * @throws SQLException
	 */
	public String checkById(String mem_id) throws SQLException;

	/**
	 *  우편번호 검색
	 * @param dong
	 * @return
	 * @throws SQLException
	 */
	public List<ZipVO> selectByDong(String dong) throws SQLException;

	/**
	 *  가입하기
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public String insertMember(MemberVO member) throws SQLException;

	
}
