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
 * Servlet implementation class ReplySave
 */
@WebServlet("/ReplySave")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySave() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get일때는 서버에서 미리설정해놔서 안해도 되지만 post일때는 해야함
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 전송시 값을 받는다.
		ReplyVO vo = new ReplyVO();
		
		vo.setBonum(Integer.parseInt(request.getParameter("bonum")));
		vo.setName(request.getParameter("name"));
		vo.setCont(request.getParameter("cont"));
	
		//1. service 객체 얻어오기
		IBoardService service = BoardServiceImpl.getService();
		
		//2. 결과값 = service 메소드 호출
		int renum = service.replySave(vo);
		
		//3. request에 저장
		request.setAttribute("renum", renum);
		
		//4. jsp에 forward 시킨다.
		request.getRequestDispatcher("board/replysave.jsp").forward(request, response);
		
	}

}
