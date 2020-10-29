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
 * Servlet implementation class InsertBoard
 */
@WebServlet("/InsertBoard")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// post일때는 캐릭터 인코딩 필요
		request.setCharacterEncoding("UTF-8");
		
		//1. 전송시 데이터 값
		/*String wr = request.getParameter("writer");
		String sb = request.getParameter("subject");
		String ma = request.getParameter("mail");
		String co = request.getParameter("content");
		String pw = request.getParameter("password");
		
		BoardVO vo = new BoardVO();
		vo.setWriter(wr);
		vo.setContent(co);
		vo.setSubject(sb);
		vo.setMail(ma);
		vo.setPassword(pw);
		vo.setWip(request.getRemoteAddr());*/ //클라이언트의 아이피를 얻어와서 저장
		
		
		//직렬화한거 beanutils사용 으로 ㄱ단단하게하기 라이브러리에 들어가있어야함
		
		
		//1 전송시 데이터값
		BoardVO vo = new BoardVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap()); // 맵에서가져와서 form의 이름 vo이름 db컬럼이름 일치
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		vo.setWip(request.getRemoteAddr()); // 따로준것
		
		
		//2 서비스 객체 얻어오기
		IBoardService service = BoardServiceImpl.getService();
		
		//3. 서비스 메소드호출
		int count = service.insertBoard(vo);
		
		//4 request에 저장
		request.setAttribute("count", count);
		
		//5 jsp로
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);	 
	
	}

}
