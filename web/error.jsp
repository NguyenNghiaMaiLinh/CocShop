<%-- 
    Document   : deleteErr
    Created on : Dec 14, 2018, 9:18:20 AM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Errors Page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="body"></div>
    <div class="grad"></div>
    <div class="welcome"></div>
    <div class="header">
        <div><span>Error</span> Page</div><br/>
        <div class="error"><s:property value="%{#request.ERROR}"/></div>
    </div>
    
</body>
</html>
