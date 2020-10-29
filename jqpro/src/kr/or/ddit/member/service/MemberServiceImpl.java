package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

/*
 * dao객체 얻어오기 - dao 메소드 호출하기
 * 
 * 자신의 service객체를 생성하고 리턴하기 - controller에서 사용
 * 
 */
public class MemberServiceImpl implements IMemberService{

	private IMemberDao dao;
	private static IMemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	public static IMemberService getService() {
		if (service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	
	@Override
	public List<MemberVO> selectAll() {
		
		List<MemberVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String checkById(String mem_id) {
			
		String dbId = null;
		
		try {
			dbId = dao.checkById(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dbId;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {

		List<ZipVO> list = null;
		
		try {
			list = dao.selectByDong(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO member) {

		String saveId = null;
		
		try {
			saveId = dao.insertMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return saveId;
	}

}
