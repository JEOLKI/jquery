package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchDong
 */
@WebServlet("/SearchDong")
public class SearchDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get일때는 안써도 되는데 post일대는 써야한다.
		request.setCharacterEncoding("utf-8");
		
		//1.
		String inputDong = request.getParameter("dong");
		
		//2. service개게 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//3. 메소드 호출
		List<ZipVO> list = service.selectByDong(inputDong);
		
		//4. request 저장
		request.setAttribute("listvalue", list);
		
		//5. jsp로 forward
		request.getRequestDispatcher("0901/dong.jsp").forward(request, response);
		
		
	}

}
