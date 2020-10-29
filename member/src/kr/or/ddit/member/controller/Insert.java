package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();

		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		//1. 클라이언트 요청시 전송하는 값 받기
/*		String id = request.getParameter("mem_id");
		String name = request.getParameter("mem_name");
		String pass = request.getParameter("mem_pass");
		String bir = request.getParameter("mem_bir");
		String hp = request.getParameter("mem_hp");
		String mail = request.getParameter("mem_mail");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		
		vo.setMem_id(id);
		vo.setMem_name(name);
		vo.setMem_pass(pass);
		vo.setMem_bir(bir);
		vo.setMem_hp(hp);
		vo.setMem_mail(mail);
		vo.setMem_zip(zip);
		vo.setMem_add1(add1);
		vo.setMem_add2(add2);
*/		
		
		//2 service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//3 메소드 호출하기
		String saveID = service.insertMember(vo);
		
		// request에 저장
		request.setAttribute("saveOk", saveID);
		
		//jsp
		request.getRequestDispatcher("member/insert.jsp").forward(request, response);
		
	}

}
