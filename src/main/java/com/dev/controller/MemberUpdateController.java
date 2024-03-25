package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;
import com.dev.vo.MemberVO;
import com.edu.controller.HttpUtil;

public class MemberUpdateController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 추출
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		//유효성 체크
		if(id.isEmpty() || password.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			req.setAttribute("error", "모든 항목을 입력하세요.");
			HttpUtil.forword(req, resp, "/view/memberUpdate.jsp");
			return;
		}
		//vo객체에 데이터 바인딩
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setMail(mail);
		
		//service객체의 메소드 호출ㅣ
		MemberService service = new MemberService();
		int n = service.memberUpdate(member);
		
		if(n > 0) {
			req.setAttribute("id", id);
			HttpUtil.forword(req, resp, "/view/memberUpdateOutput.jsp");
		}else {
				req.setAttribute("member", member);
				req.setAttribute("error", "회원정보 수정 오류입니다");
				HttpUtil.forword(req, resp, "/view/memberUpdate.jsp");
		}	
	}
}
