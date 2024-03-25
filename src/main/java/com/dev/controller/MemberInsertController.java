package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;
import com.dev.vo.MemberVO;
import com.edu.controller.HttpUtil;

public class MemberInsertController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 추출
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		System.out.println("id "+id);
		System.out.println("password "+password);
		System.out.println("name "+name);
		System.out.println("mail "+mail);
		//유효성 체크
		if(id.isEmpty() || password.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력하세요.");
			HttpUtil.forword(req, resp, "/view/memberInsert.jsp");
		}
		
		//VO객체에 데이터 바인딩
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setMail(mail);
		
		//Service객체의 메소드 호출
		MemberService service = new MemberService();
		int n = service.memberInsert(member);
		
		//Output View 페이지로 이동
		if(n > 0) {
			req.setAttribute("id", id);
			HttpUtil.forword(req, resp, "/view/memberInsertOutput.jsp");
		}else {
			req.setAttribute("error", "회원입력오류");
			HttpUtil.forword(req, resp, "/view/memberInsert.jsp");
		}
		
	}
}
