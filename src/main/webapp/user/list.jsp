<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: T14
  Date: 12/12/2024
  Time: 10:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach nguoi dung</title>
</head>
<body>
<meta charset="UTF-8">
<h1>Danh sach nguoi dung</h1>
<div>
    <div>
        <form action="/user?action=search" method="post">
            <input type="text" name="keyword" PLACEHOLDER="Nhập từ khóa tìm kiếm ">
            <input type="submit" value="Search">
        </form>
    </div>
</div>
<div>
    <a href="/user?action=add" methods="get"><button type="submit">Them nguoi dung</button></a>
</div>
<div>
   <form method="get">
       <table border="1">
           <tr>
               <td>Ma nguoi dung</td>
               <td>Ho va ten</td>
               <td>SDT</td>
               <td>Dia chi</td>
               <td colspan="2">Hanh Dong</td>
           </tr>
           <c:forEach items="${users}" var="user">
               <tr>
                   <td>${user.id}</td>
                   <td>${user.name}</td>
                   <td>${user.phone}</td>
                   <td>${user.address}</td>
                   <td><a href="/user?action=edit&id=${user.id}">Sua</a></td>
                   <td><a href="/user?action=delete&id=${user.id}">Xoa</a></td>
               </tr>
           </c:forEach>
       </table>
   </form>
</div>
</body>
</html>
