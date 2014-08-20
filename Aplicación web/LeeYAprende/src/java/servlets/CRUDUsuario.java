/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BEAN.Usuario;
import DAO.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Derick
 */
@WebServlet(name = "CRUDUsuario", urlPatterns = {"/CRUDUsuario"})
public class CRUDUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        UsuarioDao Dao = new UsuarioDao();
        String action = request.getParameter("action");
        String GO = "/inicio.jsp";

        if (action != null && action.equalsIgnoreCase("insertar")) {//insertar

            String correo = request.getParameter("email");
            String contra = request.getParameter("contra");
            String dir = request.getParameter("direccion");
            String tel = request.getParameter("telefono");
            String materno = request.getParameter("materno");
            String paterno = request.getParameter("paterno");
            String nombre = request.getParameter("nombre");
            
            PrintWriter out = response.getWriter();

            if (!Dao.insertar(nombre, paterno, materno, correo, contra, tel, dir)) {
                GO = "/emailError.jsp";
            }else{

            GO = "/agregarUsuario.jsp";
            }
        }

         this.getServletConfig().getServletContext().getRequestDispatcher(GO).forward(request, response);

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
