package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 0. 클라이언트 전송시 데이터
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		// 1. 서비스 객체
		IBoardService service = BoardServiceImpl.getService();
		
		// 2. 서비스 메소드 호출
		List<ReplyVO> list = service.replyList(bonum);
		
		// 3. request저장
		request.setAttribute("list", list);
		
		// 4. jsp로
		request.getRequestDispatcher("board/replylist.jsp").forward(request, response);
		
	}

}











