package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class ListPage
 */
@WebServlet("/ListPage")
public class ListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.클라이언트 요청시 cpage값가져오기
		int cpage = Integer.parseInt(request.getParameter("page"));
		
		//2. 서비스 얻어오기
		IBoardService service = BoardServiceImpl.getService();
		
		//3
		// 전체글갯수구하는 메소드 호출하기
		// 한페이지당 출력 글 객수 5 or 10
		int perlist = 5; // 페이지당 출력개수
		int totalcount = service.getTotalCount();
		
		// 전체 페이지수 
		int totalpage = (int) (Math.ceil((double) totalcount / perlist)) ; // 올림


		int perblock = 5; // 한화면에 표현되는 페이지수  1 -> [1][2] 2-> [1][2]  3 -> [3][4] 4 -> [3][4]  5 -> [5][6] 6->[6][7]  7 -> [7][8]
		int startpage = ((cpage-1) / perblock * perblock) + 1;
		int endpage = startpage + perblock -1;
		if(endpage > totalpage) endpage = totalpage;
		
		// cpage값에 따라서 start와 end 구하기 1페이지 1~5 2페이지 6~10 3페이지 11~15 perlist를 사용한 공식화
		// map에 설정하기
		int start = (cpage - 1) * perlist + 1;
		int end = start + perlist - 1;
		if(end > totalcount) end = totalcount;
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		// 페이지별 리스트 메소드 호출하기
		List<BoardVO> list = service.selectPage(map);
		
		// request에 결과 저장하기
		request.setAttribute("listvalue", list);
		request.setAttribute("spage", startpage);
		request.setAttribute("epage", endpage);
		request.setAttribute("tpage", totalpage);
		request.setAttribute("cpage", cpage);
		
		// jsp로
		request.getRequestDispatcher("board/listPage.jsp").forward(request, response);
		
	}
	
}
