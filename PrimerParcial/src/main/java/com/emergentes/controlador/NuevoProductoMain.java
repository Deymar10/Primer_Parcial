package com.emergentes.controlador;

import com.emergente.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "NuevoProductoMain", urlPatterns = {"/NuevoProductoMain"})
public class NuevoProductoMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        if (ses.getAttribute("listaProducto") == null) {
            ArrayList<Producto> listaux = new ArrayList<Producto>();
            ses.setAttribute("listaProducto", listaux);
        }
        ArrayList<Producto> lista = (ArrayList<Producto>)ses.getAttribute("listaProducto");
                
        String op = request.getParameter("op");
        String option = (op != null) ? op:"view";
        
        Producto obj1 = new Producto();
        int id,pos;
        
        switch(option){ 
            case "nuevo":
                request.setAttribute("miProducto", obj1);
                request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
                
            case "editar":
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                obj1 = lista.get(pos);
                request.setAttribute("miProducto", obj1);
                request.getRequestDispatcher("Productos.jsp").forward(request, response);
                break;
            case "eliminar":
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request,id);
                lista.remove(pos);
                ses.setAttribute("listaProducto", lista);
                response.sendRedirect("index.jsp");
                break;
                
            case "view":
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Producto> Product = (ArrayList<Producto>)ses.getAttribute("listaProducto");
        
        Producto pro = new Producto();
        
        pro.setId(Integer.parseInt(request.getParameter("id")));
        pro.setDescripcion(request.getParameter("descripcion"));
        pro.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        pro.setPrecio(Double.parseDouble(request.getParameter("precio")));
        pro.setCategoria(request.getParameter("Categoria"));
        
        int idt =pro.getId();
        
        if (idt == 0) { 
            int ultId;
            ultId = ultimoId(request);
            pro.setId(ultId);
            Product.add(pro);
        }
        else{
            //edicion
            Product.set(buscarIndice(request,idt),pro);
        }
        ses.setAttribute("listaper", Product);

        response.sendRedirect("index.jsp");
    }
private int buscarIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>)ses.getAttribute("listaProducto");
        
        int i=0;
        
        if (lista.size() > 0) {
            while(i < lista.size()){
                if (lista.get(i).getId() == id) {
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
    private int ultimoId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>)ses.getAttribute("listaProducto");
        
        int idaux = 0;
        for (Producto item: lista) {
            idaux = item.getId();
        }
        return idaux+1;
    }
}
