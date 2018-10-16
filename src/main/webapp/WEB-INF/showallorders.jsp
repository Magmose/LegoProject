<%-- 
    Document   : showallorders
    Created on : 11-10-2018, 11:19:47
    Author     : Bruger
--%>

<%@page import="PresentationLayer.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Order> orders = (ArrayList) request.getAttribute("orders");%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    <form name="returnpage" action="FrontController" method="POST">
        <input type="hidden" name="command" value="returnpage">
        <input type="submit" value="Return">
    </form> 
    <form name="logout" action="FrontController" method="POST">
        <input type="hidden" name="command" value="logout">
        <input type="submit" value="Log Out">
    </form>

</head>
<body>
<center>
    <h2>Order</h2>
    <%= ListUtil.makeOrderList(orders)%> 
</form>
</center>
</body>
</html>
