package kr.or.ddit.lprod.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.ProdVO;

/**
 * Servlet implementation class ProdDetail
 */
@WebServlet("/ProdDetail")
public class ProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdDetail() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 클라이언트 요청시 전달되는 값을 받는다
		String prod_id = request.getParameter("pid"); // 변수이름을 정확하게
		
		//2. service객체얻기
		ILprodService service = LprodServiceImpl.getService();
		
		//3. 메소드 호출
		ProdVO vo = service.prodDetail(prod_id);
		
		//4. request에 저장한다.
		request.setAttribute("prodDetail", vo);
		
		//5. jsp로 forward 한다.
		request.getRequestDispatcher("0828/detail.jsp").forward(request, response);
		
		
	}

}
