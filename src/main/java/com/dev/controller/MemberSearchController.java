package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;
import com.dev.vo.MemberVO;
import com.edu.controller.HttpUtil;

public class MemberSearchController implements Controller{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 추출
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		if(job.equals("search")) 
			 path="/view/memberSearch.jsp";                       
		else if(job.equals("update")) 
			path="/view/memberUpdate.jsp";                       			
		else if(job.equals("delete"))
			path="/view/memberDelete.jsp";                       			
		
		//유효성 체크
		if(id.isEmpty()) {
			req.setAttribute("error", "ID를 입력해주세요");
			HttpUtil.forword(req, resp, path);
			return;
		}
		
		//객체의 메소드 호출
		MemberService service = new MemberService();
		MemberVO member = service.memberSearch(id);
		
		//view 페이지로 이동
		if(member == null) {
			req.setAttribute("error", "검색된 정보가 없습니다.");
		}
		req.setAttribute("member", member);
		if(job.equals("search")) {
			path = "/view/memberSearchOutput.jsp";
			HttpUtil.forword(req, resp, path);
		}
	}
}
