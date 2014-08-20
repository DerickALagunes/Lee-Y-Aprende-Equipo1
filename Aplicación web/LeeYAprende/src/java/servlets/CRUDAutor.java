/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import DAO.AutorDao;
import DAO.EditorialDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Derick
 */
@WebServlet(name = "CRUDAutor", urlPatterns = {"/CRUDAutor"})
public class CRUDAutor extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        AutorDao aDao = new AutorDao();
        String action=request.getParameter("action");
        String GO = "/inicio.jsp";
        
        //eliminar
        if (action!=null && action.equalsIgnoreCase("eliminar")) {
            
            String id = request.getParameter("id");
            aDao.eliminar(Integer.parseInt(id));
            GO="/agregarAutor.jsp";
            this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
        }else if (action!=null && action.equalsIgnoreCase("insertar")) {
            //insertar
            
            String nombre = request.getParameter("nombre");
            String paterno = request.getParameter("paterno");
            String materno = request.getParameter("materno");
            
            aDao.insertar(nombre,paterno,materno);
            GO="/agregarAutor.jsp";
            this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
        }else if (action!=null && action.equalsIgnoreCase("insertarnuevo")) {
            //insertar
            
            String nombre = request.getParameter("nombre");
            String paterno = request.getParameter("paterno");
            String materno = request.getParameter("materno");
            
            if (aDao.insertar(nombre,paterno,materno)) {
                out.print("Autor insertado correctamente");
            }

            
            
        }else if (action!=null && action.equalsIgnoreCase("modificar")) {
            //modificar
            
            String nombre = request.getParameter("nombre");
            String paterno = request.getParameter("paterno");
            String materno = request.getParameter("materno");
            String id = request.getParameter("id");                   
            
            aDao.modificar(nombre,paterno,materno,Integer.parseInt(id));
            GO="/agregarAutor.jsp";
            this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);
        //recuperar    
        }else if (action!=null && action.equalsIgnoreCase("recuperar")) {
            
            
            String id = request.getParameter("id");
            aDao.recuperar(Integer.parseInt(id));
            GO="/agregarAutor.jsp";
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
