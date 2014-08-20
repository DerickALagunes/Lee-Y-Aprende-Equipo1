/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.AreaDao;
import DAO.AutorDao;
import DAO.EditorialDao;
import DAO.LibroDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Derick
 */
@WebServlet(name = "CRUDLibro", urlPatterns = {"/CRUDLibro"})
public class CRUDLibro extends HttpServlet {

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

        LibroDao Dao = new LibroDao();
        String action = request.getParameter("action");
        String GO = "/inicio.jsp";

        if (action != null && action.equalsIgnoreCase("insertar")) {
            //insertar

            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            int pags = Integer.parseInt(request.getParameter("pags"));

            int area = Integer.parseInt(request.getParameter("area"));
            int editorial = Integer.parseInt(request.getParameter("editorial"));
            String[] autor = request.getParameterValues("autor");

            int[] idautor = new int[autor.length];
            
            for (int i = 0; i < autor.length; i++) {
                idautor[i] = Integer.parseInt(autor[i]);
            }

            Dao.insertar(isbn, titulo, pags, area, editorial, idautor);

            GO = "/agregarLibro.jsp";

        } else if (action != null && action.equalsIgnoreCase("eliminar")) {

            String id = request.getParameter("id");
            Dao.eliminar(Integer.parseInt(id));
            GO = "/agregarLibro.jsp";

        } else if (action != null && action.equalsIgnoreCase("recuperar")) {

            String id = request.getParameter("id");
            Dao.recuperar(Integer.parseInt(id));
            GO = "/agregarLibro.jsp";
        } else if (action != null && action.equalsIgnoreCase("modificar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            int pags = Integer.parseInt(request.getParameter("pags"));

            int area = Integer.parseInt(request.getParameter("area"));
            int editorial = Integer.parseInt(request.getParameter("editorial"));
            String[] autor = request.getParameterValues("autor");

            int[] autores = new int[autor.length];
            
            PrintWriter out = response.getWriter();
            out.println(id);
            out.println(isbn);
            out.println(titulo);
            out.println(pags);
            out.println(area);
            out.println(editorial);
            
            for (int i = 0; i < autor.length; i++) {
                autores[i]= Integer.parseInt(autor[i]);
                out.println(autor[i]);
            }
            
            Dao.modificar(isbn, titulo, pags, area, editorial, autores,id);

            GO = "/agregarLibro.jsp";
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
