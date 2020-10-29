package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 값 가져오기
		String userId = request.getParameter("id");
		
		//1. service객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//2. 결과값 = service메소드 호출  // 중복 아이디 or null 
		String resId = service.checkById(userId);
		
		//3. 결과값을 request에 저장한다.
		request.setAttribute("result", resId);
		
		//4. jsp로 forward한다
		request.getRequestDispatcher("member/idcheck.jsp").forward(request, response);

	}
}
