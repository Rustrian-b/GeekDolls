/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClsInventory;
import Modelo.ManejoBDD;
import java.io.IOException;
import Modelo.registrosBDD;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author H4HG
 */
@WebServlet(name = "registroSales", urlPatterns = {"/registroSales"})
public class registroSales extends HttpServlet {

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
            out.println("<title>Servlet registroSales</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroSales at " + request.getContextPath() + "</h1>");
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
            
            String vClient = request.getParameter("client");
            String vAddress = request.getParameter("address");
            String vProduct = request.getParameter("product");
            int vAmount = Integer.parseInt(request.getParameter("amount"));
            int vOriginalAmount = 0;
            int vFinalAmount = 0;
            String vContinuar = "./index.html";
            
            ArrayList<ClsInventory> aInventory = ManejoBDD.Inventory();
            Iterator<ClsInventory> iter = aInventory.iterator();
            ClsInventory per = null;
            
            while(iter.hasNext())
            {
                per = iter.next();
                if(vProduct.equals(per.getvDescription()))
                {
                    vOriginalAmount = per.getvAmount();                    
                }
            }                        
            
            if(vOriginalAmount < vAmount)
            {
                try (PrintWriter out = response.getWriter()) 
                {                    
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet salidaProducto</title>");
                    out.println("<link rel=\"stylesheet\" href=\"./css/styleServlet.css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Imposible realizar la venta debido a que no existen suficiente cantidad en existencia</h1>");
                    out.println("<p>La cantidad a retirar es de " + vAmount + " y el maximo disponible es de " + vOriginalAmount + "</p>");
                    //out.println("<a href=" + vRegresar + "> Haga clic para reintentar </a><br/>");
                    out.println("<a href=" + vContinuar + "> Haga clic para salir </a> <br/>");                        
                    out.println("</body>");
                    out.println("</html>");
                }
            }else
            {
                vFinalAmount = vOriginalAmount - vAmount;
            
                registrosBDD registro = new registrosBDD();
                    
                registro.updateInventory(vProduct, vFinalAmount);
            
                boolean vResult = registro.registroSales(vProduct, vClient, vAddress, vAmount);
            
                if(vResult == true)
                {
                    try (PrintWriter out = response.getWriter()) 
                    {                
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        //out.println("<link rel=\"stylesheet\" href=\"./css/\">");
                        out.println("<title>Servlet registroEstudiantes</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Se ha registrado la venta a nombre de: " + vClient + "</h1>");
                        out.println("<h1>Que se enviara a la direccion: " + vAddress + "</h1>");
                        out.println("<h2><a href="+vContinuar+">Menú</a></h2></br>");
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
                        out.println("<title>Servlet registroEstudiantes</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>La venta no ha sido registrada, intente de nuevo.</h1>");
                        out.println("<h2><a href="+vContinuar+">Intentar de Nuevo</a></h2></br>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }                        
            processRequest(request, response);
        }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
