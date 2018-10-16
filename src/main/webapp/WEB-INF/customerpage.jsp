<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
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
        <title>Customer home page</title>


    </head>
    <body>
        <form name="showallorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="showallorders">
            <input type="submit" value="Show all orders">
        </form>
        <form name="logout" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Log Out">
        </form>
    <Center>
        <h2>Hello <%=((User) session.getAttribute("user")).getEmail()%> build your house,
            must be a minimum of 5x5x1</h2>
        <table>
            <td>
            <Center>
                <h2>House size</h2>
                <form name="houseorder" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="houseorder">
                    Length<br>
                    <input type="text" name="length" value="0">
                    <br>
                    Width<br>
                    <input type="text" name="width" value="0">
                    <br>
                    Height layers<br>
                    <input type="text" name="height" value="0">
                    <br>
                    <input type="submit" value="Check Out">
                </form>
            </Center>
            </td>
        </table>
    </Center>
</body>

</html>
