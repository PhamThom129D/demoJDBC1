<%--
  Created by IntelliJ IDEA.
  User: T14
  Date: 12/12/2024
  Time: 11:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Them nguoi dung</title>
</head>
<body>
<h1>Them nguoi dung</h1>

<form method="post">
    <table border="1">
        <tr>
            <td>Ho va ten</td>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
            <td>Mat khau</td>
            <td><input type="password" maxlength="8" name="password" required></td>
        </tr>
        <tr>
            <td>SDT</td>
            <td><input type="text" maxlength="10" name="phone"></td>
        </tr>
        <tr>
            <td>Dia chi</td>
            <td><input type="text" name="address"></td>
        </tr>

    </table>
    <input type="submit" value="Them nguoi dung">
</form>
</body>
</html>
