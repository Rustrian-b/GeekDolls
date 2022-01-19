<%-- 
    Document   : allSales
    Created on : 9/01/2022, 10:13:20 AM
    Author     : H4HG
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ManejoBDD"%>
<%@page import="Modelo.ClsSales"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todas las ventas registradas</title>
        <link rel="stylesheet" href="./css/styleShipping.css">
    </head>
    <body>
        <table>
            <thead>
                <th>
                    Codigo de venta
                </th>
                <th>
                    Producto
                </th>
                <th>
                    Cantidad
                </th>
                <th>
                    Cliente
                </th>
                <th>
                    Dirección de entrega
                </th>
                <th>
                    Estado del envio
                </th>
                <th>
                    Metodo de pago
                </th>
                <th>
                    Telefono
                </th>
                <th>
                    Telefono 2
                </th>
        </thead>
        <%
            ArrayList<ClsSales> aVenta = ManejoBDD.allSales();
            Iterator<ClsSales> iter = aVenta.iterator();
            ClsSales per = null;
            
            while(iter.hasNext())
            {
                per = iter.next();            
        %>
        <tbody class="container">
            <tr class="item">
                <td class="subitem"><%=per.getvID_number()%></td>
                <td class="subitem"><%=per.getvDescription()%></td>
                <td class="subitem"><%=per.getvAmount()%></td>
                <td class="subitem"><%=per.getvName()%></td>
                <td class="subitem"><%=per.getvAddress()%></td>
                <td class="subitem"><%=per.getvStatus()%></td>
                <td class="subitem"><%=per.getvPayment()%></td>
                <td class="subitem"><%=per.getvPhone()%></td>
                <td class="subitem"><%=per.getvPhone1()%></td>
            </tr>            
        </tbody>        
        <%}%>               
        </table>
        
    </body>
</html>
