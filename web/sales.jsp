<%-- 
    Document   : sales
    Created on : 28/12/2021, 09:46:13 PM
    Author     : H4HG
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ClsInventory"%>
<%@page import="Modelo.ManejoBDD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <form action="registroSales" method="post">
            
            <input list="browsers" name="product">
            <datalist id="browsers">
            <%
                ArrayList<ClsInventory> aProducto = ManejoBDD.InventoryToSale();
                Iterator<ClsInventory> iter = aProducto.iterator();
                ClsInventory per = null;                
                
                while(iter.hasNext())
                {
                    per = iter.next();
                    //out.println("<option value="+ per.getvDescription()+">");
                    out.println("<option>"+per.getvDescription()+"</option>");
                    //out.println(per.getvDescription());
                }    
            %>
            </datalist>                                    
            <p>Cliente: <input name="client" type="text" required="" placeholder="Nombre completo del cliente"> </p>
            <p>Dirección: <input name="address" type="text" required="" placeholder="Dirección de entrega"> </p>
            <p>Cantidad: <input name="amount" type="number" required="" placeholder="Cantidad"> </p>
            <br/>
            <input type="submit" value="Registrar venta">
        </form>
    </body>
</html>
