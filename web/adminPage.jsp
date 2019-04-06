<%-- 
    Document   : adminPage
    Created on : Dec 13, 2018, 4:18:23 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%> %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="welcome"></div>
        <div class="header">
            <div><span>Admin </span> Page</div><br/>
        </div>
        <s:if test="%{#session.USER != null}">
            <form action="logout" method="POST">
                <div class="welcome">Welcome, <s:property value="%{#session.USER}"/></div>
                <div ><input class="login" type="submit" value="Logout" /> </div>
            </form>
        </s:if>
        <s:if test="%{#session.USER == null}">
            <form action="linkLogin" method="POST">
                <div class="welcome">Welcome to Coc shop</div>
                <div ><input class="login" type="submit" value="Login" /> </div>
            </form>
        </s:if>
        <div class="search">
            <form action="searchFromAdminPage" method="PORT">
                <input type="text" name="nameValue" value="<s:property value="%{nameValue}"/>" placeholder="Name's customer" />
                <s:hidden name="userID" value="%{#session.USERID}"/>
                <input type="submit" value="Search" />
            </form>
            <s:if test="%{nameValue != null and nameValue != ''}">
                <s:if test="%{getListAccounts != null}">
                    <table border="1" rule="groups" style="text-align: center" class="tableProduct" cell>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Username</th>
                                <th>LastName</th>
                                <th>MiddleName</th>
                                <th>FirstName</th>
                                <th>Password</th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>Roles</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator  value="getListAccounts" status="counter">
                                <s:form action="editFromAdmin" theme="simple">
                                    <tr>
                                        <td><s:property value="#counter.count"/></td>
                                        <td><s:property value="username"/></td>
                                        <td><s:property value="lastName"/></td>
                                        <td><s:property value="middleName"/></td>
                                        <td><s:property value="firstName"/></td>
                                        <td><s:property value="password"/></td>
                                        <td><s:property value="address"/></td>
                                        <td><s:property value="phone"/></td>
                                        <td><s:property value="roles"/></td>
                                        <td>
                                            <s:url var="deLink" value="deleteFromAdmin">
                                                <s:param name="userID" value="%{#session.USERID}"/>
                                                <s:param name="id" value="%{username}"/>
                                                <s:param name="lastNameValue" value="%{nameValue}"/> 
                                            </s:url>
                                            <s:a href="%{deLink}">Delete</s:a>
                                            </td>
                                            <td>
                                            <s:hidden name="userID" value="%{#session.USERID}"/>
                                            <s:hidden name="id" value="%{username}"/>
                                            <s:hidden name="lastNameValue" value="%{nameValue}" />
                                            <s:submit value="Update"/>
                                        </td>
                                    </tr>
                                </s:form>
                            </s:iterator>

                        </tbody>
                    </table>

                </s:if>
                <s:if test="%{getListAccounts == null}">
                    <h2 class="char">No record found!</h2>
                </s:if>
            </s:if>
        </div>
    </body>
</html>