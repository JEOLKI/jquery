package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/ReplyDelete")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 변수가져오기
		int renum = Integer.parseInt(request.getParameter("redx"));
	
		// 2. service 객체 생성
		IBoardService service = BoardServiceImpl.getService();
		
		// 3. 메소드 호출하기
		int count = service.replyDelete(renum);
		
		// 4. request에 저장
		request.setAttribute("count", count);
		
		//5. jsp로
		
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);
		
		
		
	}

}
