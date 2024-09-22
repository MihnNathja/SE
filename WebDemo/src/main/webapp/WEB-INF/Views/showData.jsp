<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách người dùng</title>
</head>
<body>
	<h2>Danh sách người dùng</h2>
    <ol>
        <!-- Hiển thị từng tên trong danh sách -->
        <c:forEach var="name" items="${userList}">
            <li>${name}</li>
        </c:forEach>
    </ol>
    <br>
    <button type="button" onclick="window.location.href='UserServlet';">Quay lại trang nhập</button>
</body>
</html>