<%-- 
    Document   : staffPage
    Created on : Dec 13, 2018, 4:18:06 PM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>

        <div class="header">
            <div><span>Search</span> Page</div>
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
            <form action="searchFromStaff" method="POST">
                <input type="text" placeholder="String, Cafe, Sủi Cảo..." name="searchValue"  value="<s:property value="%{searchValue}"/>" />
                <s:hidden name="userID" value="%{#session.USERID}"/>
                <input type="submit" value="Search" />
            </form>
            <s:if test="%{searchValue != null and searchValue != ''}" >
                <s:if test="%{result.size() == 0 }">
                    <h2 class="char">No recored is matched !!!</h2>
                </s:if>
                <s:if test="%{result.size() != 0}">
                    <table border="1" class="tableProduct" rule="groups" style="text-align: center">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Product Name</th>
                                <th>Status</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Brand</th>
                                <th>Buy</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="result" status="counter">
                                <s:form action="editFromSatff" theme="simple">
                                    <tr>
                                        <td><s:property value="#counter.count"/></td>
                                        <td><s:property value="productName"/></td>
                                        <td><s:property value="status"/></td>
                                        <td><s:property value="description"/></td>
                                        <td><s:property value="price"/></td>
                                        <td><s:property value="brand"/></td>
                                        <td>
                                            <s:url var="deLink" value="deleteFromStaff">
                                                <s:param name="userID" value="%{#session.USERID}"/>
                                                <s:param name="id" value="%{productID}"/>
                                                <s:param name="lastSearchValue" value="%{searchValue}"/>
                                            </s:url>
                                            <s:a href="%{deLink}">Delete</s:a>
                                            </td>
                                            <td>
                                            <s:hidden name="userID" value="%{#session.USERID}"/>
                                            <s:hidden name="id" value="%{productID}"/>
                                            <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                            <s:submit value="Update"/>
                                        </td>
                                    </tr>
                                </s:form>
                            </s:iterator>
                        </tbody>
                    </table>

                </s:if>

            </s:if>
            <a href="insertProduct.jsp" class="link01" style="text-decoration: none">Create new product</a><br/><br/>

        </div>
    </body>
</html>
