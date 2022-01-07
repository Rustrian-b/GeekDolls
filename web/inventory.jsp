<%@page import="Modelo.ManejoBDD"%>
<%@page import="Modelo.ClsInventory"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
    </head>
    <body>
        <table>
            <thead>            
                <th>
                    Codigo
                </th>
                <th>
                    Descripción
                </th>
                <th>
                    Cantidad
                </th>
            </thead>
            <%
                ArrayList<ClsInventory> aProducto = ManejoBDD.Inventory();
                Iterator<ClsInventory> iter = aProducto.iterator();
                ClsInventory per = null;
                
                while(iter.hasNext())
                {
                    per = iter.next();                
            %>
                    <tbody>
                        <tr>
                            <td><%=per.getvID_number()%></td>
                            <td><%=per.getvDescription()%></td>
                            <td><%=per.getvAmount()%></td>
                        </tr>
                    </tbody>
            <%}%>                        
        </table>
        
        
        <div>
            <form action="registroInventory" method="post">
                <p>Producto: <input name="description" type="text" required="" placeholder="Descripción del producto"> </p>
                <p>Cantidad: <input name="amount" type="number" required="" placeholder="Cantidad a ingresar"> </p>
                <input type="submit" value="Registrar producto nuevo">
            </form>
        </div>
    </body>
</html>
