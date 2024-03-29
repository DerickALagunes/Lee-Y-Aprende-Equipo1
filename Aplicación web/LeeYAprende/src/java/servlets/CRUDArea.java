/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import DAO.AreaDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Derick
 */
@WebServlet(name = "CRUDArea", urlPatterns = {"/CRUDArea"})
public class CRUDArea extends HttpServlet {

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
        
        AreaDao Dao = new AreaDao();
        String action=request.getParameter("action");
        String GO = "/inicio.jsp";
        
        //eliminar
        if (action!=null && action.equalsIgnoreCase("eliminar")) {
            
            String id = request.getParameter("id");
            Dao.eliminar(Integer.parseInt(id));
            GO="/agregarArea.jsp";
             this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
            
        }else if (action!=null && action.equalsIgnoreCase("insertar")) {
            //insertar
            
            String nombre = request.getParameter("nombre");
            Dao.insertar(nombre);
            GO="/agregarArea.jsp";
             this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
            
        }else if (action!=null && action.equalsIgnoreCase("insertarnuevo")) {
            //insertar
            String nombre = request.getParameter("nombre");
            Dao.insertar(nombre);
            
        }else if (action!=null && action.equalsIgnoreCase("modificar")) {
            //modificar
            
            String nombre = request.getParameter("nombre");
            String id = request.getParameter("id");                   
            Dao.modificar(Integer.parseInt(id),nombre);
            GO="/agregarArea.jsp";
             this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
        
        //recuperar    
        }else if (action!=null && action.equalsIgnoreCase("recuperar")) {
            
            String id = request.getParameter("id");
            Dao.recuperar(Integer.parseInt(id));
            GO="/agregarArea.jsp";
             this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
            
        }

       
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
            throws ServletException, IOException {
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
