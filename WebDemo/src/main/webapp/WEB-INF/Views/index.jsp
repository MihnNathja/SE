<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Form nhập tên</title>
</head>
<body>
	 <h2>Nhập tên của bạn</h2>
    <form action="UserServlet" method="post">
        Tên: <input type="text" name="name" required />
        <input type="submit" value="Lưu tên" />
    </form>

    <form action="ShowDataServlet" method="get">
        <input type="submit" value="Xem dữ liệu" />
    </form>
</body>
</html>