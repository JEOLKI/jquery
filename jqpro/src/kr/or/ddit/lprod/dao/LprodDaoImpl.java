package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.lprod.vo.ProdVO;

public class LprodDaoImpl implements ILprodDao{

	private SqlMapClient client;
	private static ILprodDao dao;
	
	private LprodDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}
	
	public static ILprodDao gatDao() {
		if(dao == null) dao = new LprodDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<LprodVO> selectLprod() throws SQLException {
		return client.queryForList("lprod.selectLprod");
	}

	@Override
	public List<ProdVO> selectProd(String lprod_gu) throws SQLException {
		return client.queryForList("lprod.selectProd", lprod_gu);
	}

	@Override
	public ProdVO prodDetail(String prod_id) throws SQLException {
		return (ProdVO) client.queryForObject("lprod.prodDetail", prod_id);
	}
	
	
}
