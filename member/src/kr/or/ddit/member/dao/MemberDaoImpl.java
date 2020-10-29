package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
/*
 * mapper sql문을 수행 - sqlMapClient 객체가 필요 (factory에서 가져온다)
 * 자신의 객체를 생성해서 리턴시킨다. - 여러 service에서 공유해서 사용.
 */
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{

	private SqlMapClient client;
	
	private static IMemberDao dao;
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}
	
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<MemberVO> selectAll() throws SQLException {
		return client.queryForList("member.selectAll");
	}

	@Override
	public String checkById(String mem_id) throws SQLException {
		return (String) client.queryForObject("memzip.checkById", mem_id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {
		return client.queryForList("memzip.selectByDong", dong);
	}

	@Override
	public String insertMember(MemberVO member) throws SQLException {
		return (String) client.insert("memzip.insertMember", member);
	}

}


















