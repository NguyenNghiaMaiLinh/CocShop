<%-- 
    Document   : invalid
    Created on : Dec 13, 2018, 4:20:12 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="body"></div>
    <div class="grad"></div>
    <div class="welcome"></div>
    <div class="header">
        <div><span>Invalid</span> Page</div><br/>
        <div class="error"><s:property value="%{#request.ERROR}"/></div>
    </div>
    <a href="login.jsp" class="link01">Try again Login page</a>
</body>
</html>