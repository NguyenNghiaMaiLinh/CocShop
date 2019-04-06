<%-- 
    Document   : updateProductPage
    Created on : Dec 15, 2018, 11:12:42 PM
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
        <div class="welcome">Hello Staff</div>
        <div class="header">
            <div><span>Update</span> Page</div>
        </div>
        <br>
        <div class="search"> <%-- take CSS of search.jsp --%>

            <form action="updateFromStaff" method="POST">
                <table>
                    <tr>
                        <td>Product ID: </td>
                        <td><input type="text" name="productID" value="<s:property value="%{#request.DTO.productID}"/>" readonly="true"></td>
                    </tr>
                    <tr>
                        <td>Product Name:</td>
                        <td><input type="text" name="productName" value="<s:property value="%{#request.DTO.productName}"/>" readonly="true"/></td>

                    </tr
                    <tr>
                        <td>Description:</td>
                        <td><input type="text" name="description" value="<s:property value="%{#request.DTO.description}"/>" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td>Brand:</td>
                        <td><input type="text" name="brand" value="<s:property value="%{#request.DTO.brand}"/>" readonly="true"/></td>
                    </tr
                    <tr>
                        <td>Quantity:</td>
                        <td><input type="text" name="quantity" value="<s:property value="%{#request.DTO.quantity}"/>" /></td>
                        <td><s:if test="%{#request.INVALIDQUANTITY != null}">
                                <font color="red">
                                <s:property value="%{#request.INVALIDQUANTITY}"/>
                                </font><br/>
                            </s:if></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><input type="text" name="price" value="<s:property value="%{#request.DTO.price}"/>" /></td>
                        <td><s:if test="%{#request.INVALIDPRICE != null}">
                                <font color="red">
                                <s:property value="%{#request.INVALIDPRICE}"/>
                                </font><br/>
                            </s:if></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td><select name="status" class="select01">
                                <option>in Stock</option>
                                <option>out of Stock</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <s:hidden name="lastSearchValue" value="%{#request.lastSearchValue}"/>
                <s:hidden name="userID" value="%{#request.userID}"/>
                <s:submit value="update"/>
                <br/><br/>
                <a href="staffPage.jsp" class="link01" style="text-decoration: none" >Back to Search Page</a>
            </form>
        </div>
    </body>
</html>


