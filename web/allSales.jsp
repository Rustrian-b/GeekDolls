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
        <title>JSP Page</title>
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
                    Dirección
                </th>
                <th>
                    Estado del envio
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
        <tbody>
            <tr>
                <td><%=per.getvID_number()%></td>
                <td><%=per.getvDescription()%></td>
                <td><%=per.getvAmount()%></td>
                <td><%=per.getvName()%></td>
                <td><%=per.getvAddress()%></td>
                <td><%=per.getvStatus()%></td>
            </tr>            
        </tbody>        
        <%}%>               
        </table>
        
    </body>
</html>
