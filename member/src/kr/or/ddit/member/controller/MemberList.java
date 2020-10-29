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
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/List.do") //클래스이름과 서블릿이름은 같지않아도된다. ajax요청시 서블릿이름을 넣는다.
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. 클라이언트 요청시 전달 되는 데이터를 받는다.
		
		// 2. 1번에서 받은 데이터를 가지고 db를 통해서 CRUD작업이 이루어진다.
		// - Service객체 얻어온다.
		IMemberService service = MemberServiceImpl.getService();
		
		// - 결과값변수 = Service메소드 호출()
		List<MemberVO> list = service.selectAll();
		
		// 3. CRUD결과를 request에 저장한다.
		request.setCharacterEncoding("utf-8");
		request.setAttribute("listvalue", list); // 이름(jsp에서 사용할) , 값 
		
		// <저장할수 있는 영역>
		// request:다음페이지에서만사용 
		// 세션:로그인정보에 담아서 로그아웃전까지 모든페이지 
		// 어플리케이션:사이트에 들어간후 사이트를 나오기전까지 
		// 페이지 컨텍스트 :현재페이지에서만 사용할 수 있는것.
		
		// 4. CRUD작업의 결과를 가지고  view페이지 jsp로 이동하여 jsp에서 출력한다.
		// jsp페이지로 이동하는 방법 : redirect, forword
		request.getRequestDispatcher("member/member.jsp").forward(request, response); // jsp 이름 404원인
		// http://localhost/jqpro/List.do
		
		
	}

}













