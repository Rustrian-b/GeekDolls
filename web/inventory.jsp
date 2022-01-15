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
        <link rel="stylesheet" href="./css/styleInventory.css">
    </head>
    <body>
        <div>
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
                        <tbody class="container">
                            <tr class="item">
                                <td class="subitem"><%=per.getvID_number()%></td>
                                <td class="subitem"><%=per.getvDescription()%></td>
                                <td class="subitem"><%=per.getvAmount()%></td>
                            </tr>
                        </tbody>
                <%}%>                        
            </table>
        </div>
        
        <div class="formulario">
            <form action="registroInventory" method="post">
                <p>Producto: <br/><input name="description" type="text" required="" placeholder="Descripción del producto" class="caja"> </p>
                <p>Cantidad: <br/><input name="amount" type="number" required="" placeholder="Cantidad a ingresar" class="caja"> </p>
                <div class="centrar">
                <input type="submit" value="Registrar producto nuevo" class="boton">
                </div>
                <br/>
                <a href="./index.html">Menu</a>
            </form>                    
        </div>
    </body>
</html>
