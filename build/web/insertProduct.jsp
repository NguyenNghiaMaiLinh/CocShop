<%-- 
    Document   : insertProduct
    Created on : Dec 15, 2018, 8:18:30 PM
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
        <div class="welcome"></div>
        <div class="header">
            <div><span>Insert</span> Page</div>
        </div>
        <br>

        <div class="search"> <%-- take CSS of search.jsp --%>

            <form action="insertProduct" method="POST">              
                <s:if test="%{#request.INVALIDPRODUCTID != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDPRODUCTID}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Product ID" name="productID" value="<s:property value="%{productID}"/>"><br/>
                <s:if test="%{#request.INVALIDPRODUCTNAME != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDPRODUCTNAME}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Product Name" name="productName" value="<s:property value="%{productName}"/>"><br/>
                <s:if test="%{#request.INVALIDDESCRIPTION != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDDESCRIPTION}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Description" name="description" value="<s:property value="%{description}"/>"><br/>
                <s:if test="%{#request.INVALIDBRAND != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDBRAND}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Brand" name="brand" value="<s:property value="%{brand}"/>"><br/>
                <s:if test="%{#request.INVALIDQUANTITY != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDQUANTITY}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="quantity" name="quantity" value="<s:property value="%{quantity}"/>"<br/><br/>
                <s:if test="%{#request.INVALIDPRICE != null}">
                    <font color="red">
                    <s:property value="%{#request.INVALIDPRICE}"/>
                    </font><br/>
                </s:if>
                <input type="text" placeholder="Price" name="price" value="<s:property value="%{price}"/>"><br/>
                <select name="status" class="select01">
                    <option>in Stock</option>
                    <option>out of Stock</option>
                </select>
                <input type="submit" value="Insert" />
                <br/><br/>
                <a href="staffPage.jsp" class="link01" style="text-decoration: none">Back to Staff page</a>
            </form>
        </div>
    </body>
</html>
