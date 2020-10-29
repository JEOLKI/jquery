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
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 클라이언트 요청시 전달 되는 데이터를 받는다
		
		//2. 1번에서 받은 데이터를 가지고 DB를 통해서 CRUD작업이 이루어진다.
		// - service 객체 얻어오기
		ILprodService service = LprodServiceImpl.getService();
		
		// - 결과값변수 = service.메소드호출();
		List<LprodVO> list = service.selectLprod();
		
		//3. CRUD 결과를 request에 저장한다.
		request.setAttribute("listvalue", list);
		
		//4. CRUD 작업의 결과를 가지고 view페이지jsp로 이동 - jsp에서 출력 (json 데이터 생성)
		// - forword 방법
		request.getRequestDispatcher("0828/lprod.jsp").forward(request, response);
	
	}

}
