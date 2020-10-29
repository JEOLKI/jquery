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
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class List
 */
@WebServlet("/ListAll")
public class ListAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.
		//2. service객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		//3. 결과값 = 메소드 호출 ()
		List<BoardVO> list = service.selectAll();
		
		//4. 결과값을 request에 저장한다.
		request.setAttribute("listvalue", list);
		
		//5. jsp로 forward한다.
		request.getRequestDispatcher("board/listAll.jsp").forward(request, response);
		
		
	}


}
