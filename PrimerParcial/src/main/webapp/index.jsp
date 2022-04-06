<%@page import="com.emergente.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Producto> Product = (ArrayList<Producto>)session.getAttribute("listaProducto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><table border ="5">
            <tr>
                <th>PRIMER PARCIAL TEM-742<br>Nombre: Deymar Huanca Arcani<br>Carnet: 11545268 L.P.</th>    
            </tr>
        </table></center>
    <center><h1>Productos</h1></center>
    <a href="NuevoProductoMain?op=nuevo">Nuevo Producto</a>
    <br>
    <table border ="1">
            <tr>
                <th>Id</th>    
                <th>Descripición</th>    
                <th>Cantidad</th>    
                <th>Precio</th>    
                <th>Categoria</th>    
                <th>Editar</th>    
                <th>Eliminar</th>    
            </tr>
            <%
                if (Product != null) {
                        for (Producto p: Product) {
                                %>
            <tr>
                <th><%= p.getId()%></th>
                <th><%= p.getDescripcion()%></th>
                <th><%= p.getCantidad()%></th>
                <th><%= p.getPrecio()%></th>
                <th><%= p.getCategoria()%></th>
                <th><a href="NuevoProductoMain?op=editar&id=<%= p.getId()%>">Editar</th>
                <th><a href="NuevoProductoMain?op=eliminar&id=<%= p.getId()%> ">Eliminar</a></th>
            </tr>
            <%
                            }
                    }
            %>
        </table>
</body>
</html>
