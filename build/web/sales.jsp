<%-- 
    Document   : sales
    Created on : 28/12/2021, 09:46:13 PM
    Author     : H4HG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <form action="registroSales" method="post">
            
            <p>Cliente: <input name="client" type="text" required="" placeholder="Nombre completo del cliente"> </p>
            <p>Dirección: <input name="address" type="text" required="" placeholder="Dirección completa del cliente"> </p>
            <br/>
            <input type="submit" value="Registrar venta">
        </form>
    </body>
</html>
