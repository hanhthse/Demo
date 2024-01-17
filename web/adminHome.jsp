<%-- 
    Document   : adminHome
    Created on : Jan 10, 2024, 6:58:13 PM
    Author     : Acer
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN GUYS</title>
    </head>
    <body>
        <h1>WELCOME ADMIN PAGE</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Name</th>
                <th>Password</th>
            </tr>
            <tr>
                <!--Id-->
                <td>${account.accid}</td>
                <!--Username-->
                <td>${account.email}</td>
                <!--Password-->
                <td>${account.fullname}</td>
                <td>${account.password}</td>
            </tr>
        </table>
        <!--manageAccount-->
        <p><a href="admin">manage accounts</a></p>
        <!--update-->
        <button onclick="Update('${account.accid}','${account.email}', '${account.fullname}', '${account.password}')">Chinh sua account</button>
        <form action="admin?action=update" method="POST" style="display: none" id="updateAccount">
            <h1>UPDATE ACCOUNT</h1>
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
                    <td><button type="submit"/>Update</td>
                </tr>
                <br/><br/>
            </table>


        </form>
    </body>
    <script>
        function Update(id,email,fullname,password) {
                let updateForm = document.getElementById('updateAccount');
                let styleDisplay = updateForm.style.display;
                if (styleDisplay == 'none') {
                    updateForm.style.display = 'block';
                } else {
                    updateForm.style.display = 'none';
                }

                // Điền thông tin có sẵn vào form
                document.querySelector('#updateAccount input[name="accid"]').value = id;
                document.querySelector('#updateAccount input[name="email"]').value = email;
                document.querySelector('#updateAccount input[name="fullname"]').value = fullname;
                document.querySelector('#updateAccount input[name="password"]').value = password;
            }
    </script>
</html>
