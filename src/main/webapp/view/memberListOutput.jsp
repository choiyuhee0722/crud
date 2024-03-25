<%@ page import="com.dev.vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

<div class="container">
	<h3>ȸ�� ����</h3>
	
	<c:if test="${!empty list}">
		<table class="table table-stripe">
		<thead>
		<tr>
			<th>ID</th>
			<th>��й�ȣ</th>
			<th>�̸�</th>
			<th>�̸���</th>
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
			<h3>��ϵ� ȸ�������� �����ϴ�.</h3>
	</c:if>
</div>