<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../menu.jsp"/>


<c:if test="${!empty error}">
<div class="alert alert-warning alert-dismissible">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	<strong>Warning!</strong> ${error}
</div>
</c:if>
<div class="container">
<h3>수정 정보 검색</h3>

<form class="form-inline" action="/memberSearch.do" method="post">
	<label for="id" class="mb-2 mr-sm-2">아이디 : </label>
	<input type="text" name="id" class="form-control mb-2 mr-mb-2" id="id">
	<button type="submit" class="btn btn-primary mb-2">검색</button>
	<input type="hidden" name="job" value="update"/>
</form>
<br>
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null){ %>
			<h3>회원 정보 수정</h3>
		<form action="/memberUpdate.do" method="post">
		<div class="form-group">
		<label for="id">아이디 : </label>
		<input type="text" class="form-control" id="id"  name="id" readonly value="${member.id}">		
		</div>
		
		<div class="form-group">
		<label for="password">비밀번호 : </label>
		<input type="password" class="form-control" id="password"  name="password" readonly value="${member.password}">		
		</div>
		
		<div class="form-group">
		<label for="name">아이디 : </label>
		<input type="text" class="form-control" id="name"  name="name" readonly value="${member.name}">		
		</div>
		
		<div class="form-group">
		<label for="mail">이메일 : </label>
		<input type="text" class="form-control" id="mail"  name="mail" readonly value="${member.mail}">		
		</div>
		<button type="submit" class="btn btn -primary">수정</button>
		</form>
		<%}%>
</div>
</body>
</html>