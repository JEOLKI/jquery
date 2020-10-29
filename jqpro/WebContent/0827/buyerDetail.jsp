<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1. 클라이언트 요청시 전달되는 데이터를 받는다.
	String pid = request.getParameter("id");
	
	// 2. db를 통해서 CRUD 작업이 이루어 진다.
	// SqlMapClient 객체를 얻어온다.
	SqlMapClient client = SqlMapClientFactory.getClient();
	
	// sql 수행하기
	BuyerVO buyer = (BuyerVO) client.queryForObject("buyer.getDetail", pid);
	
	// 3. CRUD 작업의 결과를 가지고 응답데이터를 생성한다.
%>

	{
		"id" : "<%= buyer.getBuyer_id() %>",
		"name" : "<%= buyer.getBuyer_name() %>",
		"lgu" : "<%= buyer.getBuyer_lgu() %>",
		"add1" : "<%= buyer.getBuyer_add1() %>",
		"add2" : "<%= buyer.getBuyer_add2() %>",
		"zip" : "<%= buyer.getBuyer_zip() %>",
		"bank" : "<%= buyer.getBuyer_bank() %>",
		"bankno" : "<%= buyer.getBuyer_bankno() %>",
		"bankname" : "<%= buyer.getBuyer_bankname() %>",
		"mail" : "<%= buyer.getBuyer_mail() %>",
		"comtel" : "<%= buyer.getBuyer_comtel() %>"
	}
