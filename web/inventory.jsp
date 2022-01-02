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
                        </tr>
                    </tbody>
            <%}%>                        
        </table>
        
        
        <div>
            <form action="registroInventory" method="post">
                <p>Producto: <input name="description" type="text" required="" placeholder="Descripción del producto"> </p>
                <input type="submit" value="Registrar producto nuevo">
            </form>
        </div>
    </body>
</html>
