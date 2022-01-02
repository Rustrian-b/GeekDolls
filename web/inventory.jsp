<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
    </head>
    <body>
        <form action="registroInventory" method="post">
            <p>Producto: <input name="description" type="text" required="" placeholder="Descripción del producto"> </p>
            <input type="submit" value="Registrar producto nuevo">
        </form>
    </body>
</html>
