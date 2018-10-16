<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.ListUtil"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Order> ordersAll = (ArrayList) request.getAttribute("ordersall");%>

<!DOCTYPE html>
<html>
    <head>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 25%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>

    <form name="logout" action="FrontController" method="POST">
        <input type="hidden" name="command" value="logout">
        <input type="submit" value="Log Out">
    </form>



</head>
<body>
<center>

    <h2>Logged in as employee: <%=((User) session.getAttribute("user")).getEmail()%> </h2>
    <form name="showallorders" action="FrontController" method="POST">
        <input type="hidden" name="command" value="showallorders">
        <input type="submit" value="Show all orders">
    </form>
</form>
</center>
</html>
