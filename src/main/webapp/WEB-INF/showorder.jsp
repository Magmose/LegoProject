<%-- 
    Document   : showorder
    Created on : 11-10-2018, 10:54:38
    Author     : Bruger
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 60%;
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
    <%
        HashMap<String, Integer> hmap = (HashMap) request.getAttribute("hmap");
        Order order = (Order) request.getAttribute("order");
        if (hmap != null) {
    %>
    <h2>Order</h2>
    <table>
        <tr>
            <th>Order ID</th>
            <th>Length</th>
            <th>Width</th>
            <th>Height</th>
        </tr>
        <tr>
            <td><%= order.getIdOrder()%></td>
            <td><%= order.getHouse().getLength()%></td>
            <td><%= order.getHouse().getWidth()%></td>
            <td><%= order.getHouse().getHeight()%></td>
        </tr>
    </table>
    <h2>Bricks</h2>
    <table>
        <tr>
            <th>Type</th>
            <th>Amount</th>
            <th>All layers, for brick</th>
        </tr>
        <tr>
            <td>4x2</td>
            <td><%=(hmap.get("4x2") / order.getHouse().getHeight())%></td>
            <td><%=hmap.get("4x2")%></td>
        </tr>
        <tr>
            <td>2x2</td>
            <td><%=(hmap.get("2x2") / order.getHouse().getHeight())%></td>
            <td><%=hmap.get("2x2")%></td>
        </tr>
        <tr>
            <td>1x2</td>
            <td><%=(hmap.get("1x2") / order.getHouse().getHeight())%></td>
            <td><%=hmap.get("1x2")%></td>
        </tr>
    </table>
    <%}%>
</center>
</body>
</html>
