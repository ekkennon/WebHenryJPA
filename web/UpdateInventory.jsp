<%-- 
    Document   : UpdateInventory
    Created on : Apr 16, 2017, 3:37:15 PM
    Author     : ekk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Inventory</title>
        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Update Inventory</h1>
        <p>${ user.userid } - ${ user.username }, ${ user.adminLevel } Level</p>
        <br/>
        <p>Branch #: ${ store.storeid } </p>
        <p>Branch Name: ${ store.storeName } </p>
        <p>Branch Location: ${ store.storeAddress } </p>
        <br/>
        <p>Book Code: ${ book.inv.bookid } </p>
        <p>Book Title: ${ book.bl.title } </p>
        <p>Author: ${ book.bl.author } </p>
        <br/>
        <form action="UpdateInventory" method="post">
            <input name="onhand" id="onhand" placeholder="${ book.inv.onhand }"/>
            <button name="ty">Submit</button>
            
        </form>
        <form action="UpdateInventory" method="post">
            <input hidden id="onhand" name="onhand" value="${ book.inv.onhand }"/>
            <button>Cancel</button>
        </form>
        <p class="error">${msg}</p>
    </body>
</html>
