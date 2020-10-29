package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.ProdVO;

/**
 * Servlet implementation class ProdList
 */
@WebServlet("/ProdList")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdList() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청시 전송되는 데이터 받기
		String lgu = request.getParameter("gu"); // lprod_gu 
		
		// 2. service객체 얻어오기
		ILprodService service = LprodServiceImpl.getService();
		
		// service메소드 호출하기
		List<ProdVO> list = (List<ProdVO>) service.selectProd(lgu);
		
		//request에 저장
		request.setAttribute("listvalue", list);
		
		//jsp로 forward한다.
		//request.getRequestDispatcher("0828/prod.jsp").forward(request, response);
		request.getRequestDispatcher("0828/prod2.jsp").forward(request, response);
		
		
	}

}
