<%-- 
    Document   : updateCustomerPage
    Created on : Dec 14, 2018, 12:48:04 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Update Page</title>
        <link rel="stylesheet" href="css/style.css"> 
    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="welcome">Hello Guest</div>
        <div class="header">
            <div><span>Update</span> Page</div>
        </div>
        <br>
        <div class="search"> <%-- take CSS of search.jsp --%>

            <form action="updateFromAdmin" method="POST">
                <table>
                    <tr>
                        <td>Username: </td>

                        <td><input type="text" name="username" value="<s:property value="%{#request.DTO.username}"/>" readonly="true"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="text" name="password" value="<s:property value="%{#request.DTO.password}"/>"/></td>
                        <td><s:if test="%{#request.INVALID != null}">
                                <font color="red">
                                <s:property value="%{#request.INVALID}"/>
                                </font><br/>
                            </s:if></td>
                    </tr>
                    <tr>

                        <td>Role</td>
                        <td><select name="roles" class="select01">
                                <option>user</option>
                                <option>staff</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <s:hidden name="lastNameValue" value="%{#request.lastNameValue}"/>
                <s:hidden name="userID" value="%{#request.userID}"/>
                <s:submit value="update"/>
                <br/><br/>
                <a href="adminPage.jsp" class="link01" style="text-decoration: none" >Back to Search Page</a>
            </form>
        </div>
    </body>
</html>

