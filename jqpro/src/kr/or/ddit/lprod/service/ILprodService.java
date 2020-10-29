package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.lprod.vo.ProdVO;

public interface ILprodService {

	public List<LprodVO> selectLprod();
	
	public List<ProdVO> selectProd(String lprod_gu);
	
	public ProdVO prodDetail(String prod_id);
	
}
