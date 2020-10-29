package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyUpdate
 */
@WebServlet("/ReplyUpdate")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyUpdate() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. reply객체에 cont, renum을 가져옴
		request.setCharacterEncoding("UTF-8");
	
		String cont = request.getParameter("cont");
		int renum = Integer.parseInt(request.getParameter("renum"));
	
		ReplyVO vo = new ReplyVO();
		vo.setCont(cont);
		vo.setRenum(renum);
		
		// 2. service객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		// 3. 결과값 = service메소드 호출하기
		int count = service.replyUpdate(vo);
		
		// 4. 결과값을 request에 저장
		request.setAttribute("count", count);
		
		// 5. jsp로
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);
		
	
	}

}
