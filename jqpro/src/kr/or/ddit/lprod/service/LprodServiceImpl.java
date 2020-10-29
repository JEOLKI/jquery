package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.lprod.vo.ProdVO;

public class LprodServiceImpl implements ILprodService{

	private ILprodDao dao;
	private static ILprodService service;
	
	private LprodServiceImpl() {
		dao = LprodDaoImpl.gatDao();
	}
	
	public static ILprodService getService() {
		if(service == null) service = new LprodServiceImpl();
		
		return service;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		
		List<LprodVO> list = null;
		
		try {
			list = dao.selectLprod();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ProdVO> selectProd(String lprod_gu) {
		List<ProdVO> list = null;
		
		try {
			list = dao.selectProd(lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProdVO prodDetail(String prod_id) {
		
		ProdVO vo = null;
		
		try {
			vo = dao.prodDetail(prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
