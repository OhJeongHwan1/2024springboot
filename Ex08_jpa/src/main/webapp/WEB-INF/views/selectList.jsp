<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
총 글의 개수: ${totalElements}
총 페이지: ${totalPages}
size: ${size}
pageNumber: ${pageNumber}
number of elements: ${numberOfElements} <br>
<c:forEach var="member" items="${members}">
    ${member.id} / ${member.name} / ${member.email}
    <hr>
</c:forEach>
</body>
</html>