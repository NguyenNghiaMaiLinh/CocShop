<%-- 
    Document   : login
    Created on : Dec 13, 2018, 5:50:58 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/style.css">
        <s:head/>
    </head>
    <body>
        <form action="login" method="POST">
            <div class="body"></div>
            <div class="grad"></div>
            <div class="header">
                <div><span>Login</span> Page</div>
            </div>
            <br/>
            <div class="search"><%--the same css of search page--%>
                <s:if test="%{#request.INVALIDUSERNAME != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDUSERNAME}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Username" name="username" value="" /><br/>
                <s:if test="%{#request.INVALIDPASSWORD != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDPASSWORD}"/>
                    </font><br/>
                </s:if>
                <input type="password" placeholder="Password" name="password" value="" /><br/>
                <input type="submit" value="Login" /><br/><br/>
                <a href="insertAccount.jsp" class="link01" style="text-decoration: none">Create new account</a><br/><br/>
                <a href="userPage.jsp" class="link01" style="text-decoration: none">To Home page</a>
            </div>

        </form>

    </body>
</html>
