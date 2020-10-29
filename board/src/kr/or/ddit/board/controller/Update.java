package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 글번호 가져오기
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		// service 객체
		IBoardService service = BoardServiceImpl.getService();
		
		// 메소드 호출
		BoardVO vo = service.updateSelect(seq);
		
		request.setAttribute("boardvo", vo);
		
		request.getRequestDispatcher("board/view.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트에서 전송하는 데이터 
		BoardVO vo = new BoardVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//1. service객체 얻어오기
		IBoardService service = BoardServiceImpl.getService();
		
		//2. 메소드 호출
		int count = service.updateBoard(vo);
		
		// request 저장
		request.setAttribute("count", count);
		
		
		// jsp로
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);
		
		
	}

}
