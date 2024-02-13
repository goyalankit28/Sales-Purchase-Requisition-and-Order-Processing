<%-- 
    Document   : register
    Created on : Apr 5, 2023, 3:04:06 PM
    Author     : ankitgoyal
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<html>
    <link rel='stylesheet' href='form-style.css' type='text/css' /> 
    <body>-->

<html>
    <head>
        <title>Add User Form</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
            }
            form {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0px 0px 10px #d9d9d9;
                max-width: 600px;
                margin: 0 auto;
            }
            h2 {
                text-align: center;
                color: #333333;
                margin-top: 0;
            }
            table {
                margin-bottom: 20px;
                width: 100%;
            }
            td {
                padding: 10px;
                border: none;
                font-size: 16px;
                color: #666666;
            }
            input[type="text"],
            input[type="password"] {
                padding: 8px;
                border-radius: 5px;
                border: 1px solid #d9d9d9;
                width: 100%;
                font-size: 16px;
                color: #666666;
                box-sizing: border-box;
                margin-bottom: 10px;
            }
            input[type="radio"] {
                margin-right: 5px;
                margin-left: 10px;
            }
            label {
                font-size: 16px;
                color: #666666;
                display: inline-block;
                margin-bottom: 5px;
                margin-right: 10px;
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: #ffffff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover {
                background-color: #3e8e41;
            }
            .select-box select {
			display: block;
			padding: 10px;
			font-size: 16px;
			border: 2px solid #ccc;
			border-radius: 4px;
			background-color: #f8f8f8;
		}
		.select-box select:focus {
			border-color: #7dc2ff;
			box-shadow: 0 0 0 2px rgba(61, 139, 255, 0.25);
			outline: none;
		}
        </style>
    </head>
    <body>
        <h2>Register a New User</h2>
        <form:form modelAttribute="user"  method="post">
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstName" size="30" /></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastName" size="30" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="emailId" size="30" /></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" size="30" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" size="30" /></td>
                </tr>
            </table>
            <div style="margin: 20px;">
                Role:
                <form:select path="userRole">
                    <form:option value="Supplier">Supplier</form:option>
                    <form:option value="Customer">Customer</form:option>
                </form:select>
            </div>
            <input type="button" value="Check Username Availablity" onclick="checkId()" /><br> 
            <div style="text-align: center;">
                <input type="submit" value="Register" />
            </div>
        </form:form>
            
        <script>
            var request;
            function checkId()
            {
            request=new XMLHttpRequest();
            request.onreadystatechange=getResult;
            var v=document.getElementById("username").value;
            request.open("get", "CheckUid?email="+v, true);
            request.send(null);            
            }
            function getResult()
            {
                if(request.readyState==4 && request.status==200)
                {
                    ans=request.responseText;
                    document.getElementById("output").innerHTML=ans;   
                }
                else
                    document.getElementById("output").innerHTML="";    
            }
        </script>

    </body>
</html>