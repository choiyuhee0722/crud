<%@ page import="com.dev.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

<div class="container">
	<h3>회원 정보</h3>
	
	<c:if test="${!empty list}">
		<table class="table table-stripe">
		<thead>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		</thead>
			<tbody>
			<c:forEach items="${list}" var="member">
				<tr>
					<th>${member.id}</th>
					<th>${member.password}</th>
					<th>${member.name}</th>
					<th>${member.mail}</th>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty list}">
			<h3>등록된 회원정보가 없습니다.</h3>
	</c:if>
</div>