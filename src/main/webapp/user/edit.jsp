<%--
  Created by IntelliJ IDEA.
  User: T14
  Date: 12/12/2024
  Time: 3:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cap nhat thong tin</title>
</head>
<body>
<h1>Cập nhật thông tin người dùng</h1>
<form method="post">
    <table border="1">
        <tr>
            <td>Ho va ten</td>
            <td><input type="text" name="name" value="${user.getName()}" required></td>
        </tr>
        <tr>
            <td>Mat khau</td>
            <td><input type="password" name="password" value="${user.getPassword()}" required></td>
        </tr>
        <tr>
            <td>SDT</td>
            <td><input type="text" name="phone" value="${user.getPhone()}"></td>
        </tr>
        <tr>
            <td>Dia chi</td>
            <td><input type="text" name="address" value="${user.getAddress()}"></td>
        </tr>

    </table>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
