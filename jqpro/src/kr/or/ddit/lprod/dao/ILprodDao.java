package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.lprod.vo.ProdVO;

public interface ILprodDao {
	
	public List<LprodVO> selectLprod() throws SQLException;
	
	public List<ProdVO> selectProd(String lprod_gu) throws SQLException;
	
	public ProdVO prodDetail(String prod_id) throws SQLException;
	
}
