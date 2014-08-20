package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BEAN.Libro;
import java.util.List;
import DAO.LibroDao;

public final class inicio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    boolean admin = (Boolean) session.getAttribute("admin");
    boolean user = (Boolean) session.getAttribute("user");
    boolean log;
    
    if (admin || user) log=true;
    else log =false;
    

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"./images/logo2.png\">\n");
      out.write("\n");
      out.write("        <title>Biblioteca</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-3.1.1-dist/css/bootstrap.min.css\">               \t\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/dataTables.bootstrap.css\">\t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>              \t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.dataTables.js\"></script>\t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/dataTables.bootstrap.js\"></script>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('#tabla').dataTable({\n");
      out.write("                    \"lengthMenu\": [[10, 25, 50, -1], [10, 25, 50, \"All\"]],\n");
      out.write("                    \"pagingType\": \"full_numbers\",\n");
      out.write("                    \"language\": {\n");
      out.write("                        \"emptyTable\": \"No hay datos disponibles en la tabla\",\n");
      out.write("                        \"info\": \" _START_ a _END_ de un total de _TOTAL_ registros\",\n");
      out.write("                        \"infoEmpty\": \"Ningún registro\",\n");
      out.write("                        \"search\": \"Busqueda de libros:  _INPUT_\",\n");
      out.write("                        \"zeroRecords\": \"No hay registros para mostrar\\nintente agregar a su busqueda simbolos\\n(-@#?!)\",\n");
      out.write("                        \"paginate\": {\n");
      out.write("                            \"first\": \"<span class=\\\"glyphicon glyphicon-fast-backward\\\"></span>\",\n");
      out.write("                            \"previous\": \"<span class=\\\"glyphicon glyphicon-backward\\\"></span>\",\n");
      out.write("                            \"next\": \"<span class=\\\"glyphicon glyphicon-forward\\\"></span>\",\n");
      out.write("                            \"last\": \"<span class=\\\"glyphicon glyphicon-fast-forward\\\"></span>\",\n");
      out.write("                        },\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("         <link href=\"./css/colores.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/nav.css\" rel=\"stylesheet\">   \n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\">Lee y Aprende</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-collapse collapse\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"./inicio.jsp\">Inicio</a></li>\n");
      out.write("                            ");
if (admin){ 
      out.write("\n");
      out.write("                        <li><a href=\"./administrador.jsp\">Herramientas Adm</a></li>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            ");
if (user){ 
      out.write("\n");
      out.write("                        <li><a href=\"#\">Libros</a></li>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    ");
if (!log) { 
      out.write("\n");
      out.write("                    <form class=\"navbar-form navbar-right form-signin\"\n");
      out.write("                          role=\"form\"  method=\"post\" action=\"login\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" placeholder=\"Usuario\"\n");
      out.write("                                   class=\"form-control\" required name=\"nombre\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"password\" placeholder=\"Contraseña\" \n");
      out.write("                                   class=\"form-control\" required name=\"contra\">\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Entrar</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");
 } else if(log){ 
      out.write("\n");
      out.write("                    <form class=\"navbar-form navbar-right form-signin\" role=\"form\" action=\"cerrar\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Cerrar sesión</button>\n");
      out.write("                    </form>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                </div><!--/.navbar-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"padding-top: 45px; padding-bottom: 80px\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-12 cuerpo\">\n");
      out.write("                <div class=\"col-md-6 cuerpo\">\n");
      out.write("                    <h1>Biblioteca Lee y Aprende</h1>\n");
      out.write("                    <p class=\"lead\">Bienvenido al sistema de biblioteca</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <br />\n");
      out.write("                    <p class=\"lead\">Libro con mas existencias:<button type=\"submit\" class=\"btn btn-default\">Buscar</button></p>\n");
      out.write("                    <p class=\"lead\">Editorial con menos libros :<button type=\"submit\" class=\"btn btn-default\">Buscar</button></p>       \n");
      out.write("                </div>\n");
      out.write("                                    \n");
      out.write("                <br /><br />\n");
      out.write("                \n");
      out.write("                <table id=\"tabla\" class=\"table table-striped table-bordered\" style=\"font-size: small;\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ISBN</th>\n");
      out.write("                            <th>Titulo</th>\n");
      out.write("                            <th>#Paginas</th>\n");
      out.write("                            <th>Autor</th>\n");
      out.write("                            <th>Editorial</th>\n");
      out.write("                            <th>Área</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("                        ");

                            LibroDao Dao = new LibroDao();
                            List<Libro> libros = Dao.consultar();

                            for (int i = 0; i < libros.size(); i++) {
                                Libro temporal = libros.get(i);
                                

                                boolean estado = temporal.isMostrar();
                                String nautor = temporal.getAutor().getNombre() + " " + temporal.getAutor().getApaterno();

                                for (int j = i+1; j < libros.size(); j++) {
                                    Libro compara = libros.get(j);
                                    
                                    if (temporal.getIsbn().equals(compara.getIsbn())) {

                                        nautor = nautor + " , " + compara.getAutor().getNombre() + " " + compara.getAutor().getApaterno();
                                        i=i+1;
                                    }
                                }
                                
                                String isbn = temporal.getIsbn();
                                String titulo = temporal.getTitulo();
                                int paginas = temporal.getNum_paginas();
                                String editorial = temporal.getEditorial().getNombre();
                                String area = temporal.getArea().getNombreArea();
                                int id = temporal.getIdLibro();
                                
                                if (estado) {
                                        
                                    
                        
      out.write("        \n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(isbn);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(titulo);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(paginas);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(nautor);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(editorial);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(area);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        ");
 }
                                } 
      out.write("    \n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div><!-- /.container -->\n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"navbar navbar-default navbar-fixed-bottom\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav\">    \n");
      out.write("                    <li>\n");
      out.write("                        <img src=\"./images/logo2.png\" />\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"./equipo.jsp\">© 2014 – 2020 Blue Software Desing - Lee Y Aprende</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right \">\n");
      out.write("                    <li><a href=\"./contacto.jsp\">Contacto</a></li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"./bootstrap-3.1.1-dist/js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
