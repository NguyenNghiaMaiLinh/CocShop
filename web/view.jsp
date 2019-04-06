<%-- 
    Document   : view
    Created on : Dec 15, 2018, 11:28:41 AM
    Author     : Mai Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <br/>
        <div class="header">
            <div><span>Cart</span> Page</div>
        </div>

        <s:if test="%{#session.USER != null}">
            <form action="logout" method="POST">
                <div class="welcome">Welcome, <s:property value="%{#session.USER}"/></div>
                <div ><input class="login" type="submit" value="Logout" /> </div>
            </form>
        </s:if>
        <s:if test="%{#session.USER == null}">
            <form action="linkLogin" method="POST">
                <div ><input class="login" type="submit" value="Login" /> </div>
            </form>
        </s:if>
        <div class="search">
            <s:if test="%{#session.shoppingCart != null}">
                <table border="1" style="text-align: center">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{#session.shoppingCart.cart}" var="product" status="counter"  >
                            <s:form action="removeFromCart" theme="simple"  >
                                <tr>
                                    <td><s:property value="#counter.count"/></td>
                                    <td><s:property value="value.productName"/></td>
                                    <td><s:property value="value.price"/></td>
                                    <td><s:property value="value.quantity"/></td>
                                    <td>
                                        <s:hidden name="id" value="%{key}"/>
                                        <s:submit value="Remove"/>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>
                <label>Total:</label><s:property value="%{#session.shoppingCart.total}"/><br/>
                <s:form action="countinute">
                    <s:submit value="add more Product to your cart "/>
                </s:form>
            </s:if>
            <s:if test="%{#session.shoppingCart == null}">
                <br/><br/>
                <h3>Your cart is empty</h3>
                <a href="userPage.jsp" class="link01" style="text-decoration: none">Click to buy</a>
            </s:if>
        </div>
    </body>
</html>
