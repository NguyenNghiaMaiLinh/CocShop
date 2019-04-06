<%-- 
    Document   : insertAccount
    Created on : Dec 14, 2018, 6:03:53 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert Page</title>
        <link rel="stylesheet" href="css/style.css"> 
    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="welcome">Hello Guest</div>
        <div class="header">
            <div><span>Insert</span> Page</div>
        </div>
        <br>
        <div class="search"> <%-- take CSS of search.jsp --%>

            <form action="insertAccount" method="POST">              
                <s:if test="%{#request.INVALIDUSERNAME != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDUSERNAME}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Username" name="username" value="<s:property value="%{username}"/>"><br/>
                <s:if test="%{#request.INVALIDLASTNAME != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDLASTNAME}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Last Name" name="lastName" value="<s:property value="%{lastName}"/>"><br/>
                <s:if test="%{#request.INVALIDMIDDLENAME != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDMIDDLENAME}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Middle Name" name="middleName" value="<s:property value="%{middleName}"/>"><br/>
                <s:if test="%{#request.INVALIDFIRSTNAME != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDFIRSTNAME}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="First Name" name="firstName" value="<s:property value="%{firstName}"/>"><br/>
                <s:if test="%{#request.INVALIDPASSWORD != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDPASSWORD}"/>
                    </font><br/>
                </s:if>
                <input type="password" placeholder="Password" name="password" /><br/>
                <s:if test="%{#request.INVALIDCOMFIRM != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDCOMFIRM}"/>
                    </font><br/>
                </s:if>
                <input type="password" placeholder="Confirm" name="confirm"/><br/>
                <s:if test="%{#request.INVALIDADDRESS != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDADDRESS}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Adrress" name="address" value="<s:property value="%{address}"/>"><br/>
                <s:if test="%{#request.INVALIDPHONE != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDPHONE}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Phone" name="phone" value="<s:property value="%{phone}"/>"><br/>
                <input type="submit" value="Insert" />
                <br/><br/>
                <a href="userPage.jsp" class="link01" style="text-decoration: none">Back to Home page</a>
            </form>
        </div>
    </body>
</html>

