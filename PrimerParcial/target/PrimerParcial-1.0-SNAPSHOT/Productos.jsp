<%@page import="com.emergente.modelo.Producto"%>
<%
    Producto p = (Producto)request.getAttribute("miProducto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><h1>Productos</h1></center>
        <form action="NuevoProductoMain" method="POST">
            <input type="hidden" name="id" value="<%= p.getId() %>"/>
            <table>
                <tr>
                <td>Descripcion</td>
                <td><input type = "text" name ="descripcion" value="<%= p.getDescripcion()%>"></td>
            </tr>
            
            <tr>
                <td>Cantidad</td>
                <td><input type = "text" name ="cantidad" value="<%= p.getCantidad()%>"></td>
            </tr>
            
            <tr>
                <td>Precio</td>
                <td><input type = "text" name ="precio" value="<%= p.getPrecio()%>"></td>
            </tr>
            <br>
            <tr>
                <td>Categoria</td>
                <td><input type = "text" name ="Categoria" value="<%= p.getCategoria()%>"></td>
            </tr>
            
            <tr>
                <td></td>
                <td><input type="submit" value="Agregar"></td>
            </tr>
            </table>
            
        </form>
    </body>
</html>
