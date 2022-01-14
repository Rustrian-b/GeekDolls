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
        <link rel="stylesheet" href="./css/styleSales.css">
    </head>
    <body>
        <form action="registroSales" method="post">
            <p> Producto:<br/>
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
            </p>
            <p>Cliente: <br/><input name="client" type="text" required="" placeholder="Nombre completo del cliente" class="caja"> </p>
            <p>Dirección: <br/><input name="address" type="text" required="" placeholder="Dirección de entrega" class="caja"> </p>
            <p>Cantidad: <br/><input name="amount" type="number" required="" placeholder="Cantidad" class="caja"> </p>
            <p> Metodo de pago: <br/>
            <input list="metodo" name="payment">
            <datalist id="metodo">
                <option value="TRANSFERENCIA"></option>
                <option value="EFECTIVO"></option>
            </datalist>
            </p>            
            <br/>
            <div class="centrar">
                <input type="submit" value="Registrar venta" class="boton">
            </div>
        </form>
    </body>
</html>
