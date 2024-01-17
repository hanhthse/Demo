<%-- 
    Document   : display
    Created on : Jan 16, 2024, 6:30:43 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="admin?action=search" method="POST">
        <input type="text" name="keyword" value="" placeholder="enter somthings" />
        <select name="property">
            <option value="accid">ID</option>
            <option value="email">EMAIL</option>
            <option value="fullname">FullName</option>
            <option value="password">Password</option>
        </select>
        <input type="submit" value="search">
    </form>
    
    <body>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Name</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listAccount}" var="account">
                <tr>
                    <!--Id-->
                    <td>${account.accid}</td>
                    <!--Username-->
                    <td>${account.email}</td>
                    <!--Password-->
                    <td>${account.fullname}</td>
                    <td>${account.password}</td>
                    <!--delete-->
                    <td>
                        <form action="admin?action=delete&accid=${account.accid}" method="POST">
                            <input type="submit" value="delete">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <p><button onclick="addAccount()">ADD NEW ACCOUNT</button></p>
        <form action="admin?action=add" method="POST" style="display: none" id="addAccount">
            <h1>ADD NEW ACCOUNT</h1>
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="accid" value="" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="" /></td>
                </tr>
                <tr>
                    <td>Fullname</td>
                    <td><input type="text" name="fullname" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td><button type="submit"/>Create</td>
                </tr>
                <br/><br/>
            </table>
        </form>
        <script>
            function addAccount() {
                let form = document.getElementById('addAccount');
                let styleDisplay = form.style.display;
                if (styleDisplay == 'none') {
                    form.style.display = 'block';
                } else {
                    form.style.display = 'none'
                }
            }
        </script>
    </body>
    
</html>
