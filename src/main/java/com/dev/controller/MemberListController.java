package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.biz.MemberService;
import com.dev.vo.MemberVO;
import com.edu.controller.HttpUtil;

public class MemberListController implements Controller{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberService();
		ArrayList<MemberVO> list = service.memberList();
		
		req.setAttribute("list", list);
		HttpUtil.forword(req, resp, "/view/memberListOutput.jsp");
		
	}
}
