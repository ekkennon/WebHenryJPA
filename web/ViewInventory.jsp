<%-- 
    Document   : ViewInventory
    Created on : Apr 16, 2017, 4:39:46 PM
    Author     : ekk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <style>
            .error {
                color: red;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
        <p>Branch #: ${ store.storeid } </p>
        <p>Branch Name: ${ store.storeName } </p>
        <p>Branch Location: ${ store.storeAddress } </p>
        <c:if test="${user.adminLevel eq 'Admn'}">
            <form action="ViewInventory" method="post">
                <input name="bookid" id="bookid" placeholder="Book Code"/>
                <button>Edit Record</button>
            </form>
            <br/>
        </c:if>
    
        <table border="1">
            <tr>
                <th bgcolor="D5F2F2">
                    Store
                </th>
                <th bgcolor="D5F2F2">
                    Book Code
                </th>
                <th bgcolor="D5F2F2">
                    Title
                </th>
                <th bgcolor="D5F2F2">
                    Retail Price
                </th>
                <th bgcolor="D5F2F2">
                    Quantity
                </th>
            </tr>
            
            <c:forEach var="bk" items="${ books }">
                <tr>
                    <td align="right">
                        ${ bk.inv.storeid }
                    </td>
                    <td align="right">
                        ${ bk.inv.bookid }
                    </td>
                    <td align="right">
                        ${ bk.bl.title }
                    </td>
                    <td align="right">
                        ${ bk.bl.price }
                    </td>
                    <td align="right">
                        ${ bk.inv.onhand }
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p class="error">${msg}</p>
    </body>
</html>
