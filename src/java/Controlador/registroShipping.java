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
@WebServlet(name = "registroShipping", urlPatterns = {"/registroShipping"})
public class registroShipping extends HttpServlet {

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
            out.println("<title>Servlet registroShipping</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroShipping at " + request.getContextPath() + "</h1>");
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
        
        int vID = Integer.parseInt(request.getParameter("id_number"));
        String vContinuar = "./index.html";
        String vRepetir = "./shipping.jsp";
        
        registrosBDD update = new registrosBDD();
        
        boolean vResult = update.updateSales(vID);
        
        if(vResult == true)
        {
            try (PrintWriter out = response.getWriter()) 
            {                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"./css/styleServlet.css\">");
                out.println("<title>Envio confirmado</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Se ha empaco el producto: " + vID + ", producto listo para entrega</h1>");
                out.println("<h2><a href="+vRepetir+">Confirmar otro envio</a></h2></br>");
                out.println("<h2><a href="+vContinuar+">Men??</a></h2></br>");
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
                out.println("<link rel=\"stylesheet\" href=\"./css/styleServlet.css\">");
                out.println("<title>Envio no confirmado</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>El envio no pudo ser confirmado, intente de nuevo.</h1>");
                out.println("<h2><a href="+vRepetir+">Intentar de Nuevo</a></h2></br>");
                out.println("<h2><a href="+vContinuar+">Volver al menu</a></h2></br>");
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
