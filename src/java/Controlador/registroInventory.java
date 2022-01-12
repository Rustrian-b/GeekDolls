/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.registrosBDD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author H4HG
 */
@WebServlet(name = "registroInventory", urlPatterns = {"/registroInventory"})
public class registroInventory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registroInventory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroInventory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {                
        processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        
        String vDescription = request.getParameter("description");
        int vAmount = Integer.parseInt(request.getParameter("amount"));
        String vContinuar = "./index.html";
        String vRepetir = "./inventory.jsp";
        
        registrosBDD registro = new registrosBDD();
        
        boolean vResult = registro.registroInventory(vDescription, vAmount);
        
        if(vResult == true)
        {
            try (PrintWriter out = response.getWriter()) 
            {                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"./css/styleServlet.css\">");
                out.println("<title>Producto registrado</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Se ha registrado "+ vAmount +" unidades del producto: " + vDescription + "</h1>");                
                out.println("<h2><a href="+vContinuar+">Menú</a></h2></br>");
                out.println("<h2><a href="+vRepetir+">Registrar nuevo producto</a></h2></br>");
                out.println("</body>");
                out.println("</html>");
            }            
        }
        else
        {
            try (PrintWriter out = response.getWriter()) 
            {                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Producto no registrado</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>El producto no ha sido registrado.</h1>");
                out.println("<h2><a href="+vRepetir+">Intentar de Nuevo</a></h2></br>");
                out.println("<h2><a href="+vContinuar+">Menú</a></h2></br>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
