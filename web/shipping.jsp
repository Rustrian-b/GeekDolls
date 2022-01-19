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
        <link rel="stylesheet" href="./css/styleShipping.css">
    </head>
    <body>                    
        <h1>Confirmar envio</h1>
        <form action="registroShipping" method="post" class="contenedor">            
            <p>Codigo de venta:</p> <input name="id_number" type="number" required="" placeholder="Numero de venta que fue empaquetado" class="caja">
            <input type="submit" value="Confirmar venta" class="boton">
        </form>
        <br/>
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
                <th>
                    Telefono
                </th>
                <th>
                    Telefono 2
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
        <tbody class="container">
            <tr class ="item">
                <td class ="subitem"><%=per.getvID_number()%></td>
                <td class ="subitem"><%=per.getvDescription()%></td>
                <td class ="subitem"><%=per.getvAmount()%></td>
                <td class ="subitem"><%=per.getvName()%></td>
                <td class ="subitem"><%=per.getvAddress()%></td>
                <td class ="subitem"><%=per.getvStatus()%></td>
                <td class ="subitem"><%=per.getvPayment()%></td>
                <td class ="subitem"><%=per.getvPhone()%></td>
                <td class ="subitem"><%=per.getvPhone1()%></td>
            </tr>            
        </tbody>        
        <%}%>               
        </table>      
        <br/>
        <div class="conta">
            <a href="./index.html">Menu</a>
        </div>
    </body>
</html>
