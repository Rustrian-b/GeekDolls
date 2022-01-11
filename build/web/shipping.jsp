<%-- 
    Document   : shipping
    Created on : 28/12/2021, 09:46:31 PM
    Author     : H4HG
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ClsSales"%>
<%@page import="Modelo.ManejoBDD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Envios</title>
    </head>
    <body>
        <h1>Confirmar envio</h1>
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
                <th>
                    Metodo de pago
                </th>
        </thead>
        <%
            ArrayList<ClsSales> aVenta = ManejoBDD.Sales();
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
                <td><%=per.getvPayment()%></td>
            </tr>            
        </tbody>        
        <%}%>               
        </table>
        
        <div>
            <form action="registroShipping" method="post">
                <p>Codigo de venta: <input name="id_number" type="number" required="" placeholder="Numero de venta que fue empaquetado"> </p>
                <input type="submit" value="Confirmar venta">
            </form>
        </div>
    </body>
</html>
