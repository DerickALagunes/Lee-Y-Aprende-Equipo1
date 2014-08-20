package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.EditorialDao;
import BEAN.Editorial;
import java.util.List;

public final class agregarEditorial_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    
    HttpSession sesion = request.getSession();
    sesion.setAttribute("admin", true);
    boolean admin = (Boolean) session.getAttribute("admin");
        

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <title>Agregar Libro</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"./images/logo2.png\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <link href=\"./css/colores.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/nav.css\" rel=\"stylesheet\"> \n");
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
      out.write("                    \"lengthMenu\": [[5, 10, 25, 50, -1], [5, 10, 25, 50, \"All\"]],\n");
      out.write("                    \"pagingType\": \"full_numbers\",\n");
      out.write("                    \"language\": {\n");
      out.write("                        \"emptyTable\": \"No hay datos disponibles en la tabla\",\n");
      out.write("                        \"info\": \" _START_ a _END_ de un total de _TOTAL_ registros\",\n");
      out.write("                        \"infoEmpty\": \"Ningún registro\",\n");
      out.write("                        \"search\": \"Aplicar filtro  _INPUT_ a la tabla\",\n");
      out.write("                        \"zeroRecords\": \"No hay registros para mostrar\",\n");
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
      out.write("    </head>\n");
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
      out.write("                <div class=\"collapse navbar-collapse\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"./inicio.jsp\">Inicio</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"./administrador.jsp\">Herramientas Adm</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <form class=\"navbar-form navbar-right form-signin\" role=\"form\" action=\"cerrar\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Cerrar sesión</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div><!--/.navbar-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
 if (admin) { 
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"padding-top: 45px; padding-bottom: 80px;\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-1\">   \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-10 cuerpo\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <form class=\"form-horizontal\" method=\"post\" action=\"CRUDEditorial?action=insertar\">\n");
      out.write("                    <fieldset>\n");
      out.write("\n");
      out.write("                        <!-- Form Name -->\n");
      out.write("                        <legend>Agregar una editorial</legend>\n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"nombre\">Nombre de la editorial nueva</label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"nombre\" name=\"nombre\" type=\"text\" placeholder=\"campo requerido*\" class=\"form-control input-md\" required=\"\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Button -->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"insertar\"></label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <button id=\"insertar\" name=\"insertar\" class=\"btn btn-default\">Agregar</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </fieldset>\n");
      out.write("                </form>\n");
      out.write("                <!-- Termina formulario-->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <table id=\"tabla\" class=\"table table-striped table-bordered\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Editorial</th>\n");
      out.write("                            <th>Estado</th>\n");
      out.write("                            <th>Acciones</th>\n");
      out.write("                            <th>Acciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            EditorialDao eDao = new EditorialDao();
                            List<Editorial> editorial = eDao.consultar();

                            for (int i = 0; i < editorial.size(); i++) {
                                Editorial temporal = editorial.get(i);

                                int id = temporal.getIdEditorial();
                                String nombre = temporal.getNombre();
                        
      out.write("        \n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <td>");
 out.print(temporal.getNombre()); 
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                ");


                                    if (temporal.isEstado()) {
                                        out.print("activo");
                                    } else {
                                        out.print("inactivo");
                                    }

                                
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                ");
 if (temporal.isEstado()) {
      out.write("\n");
      out.write("                                <form method=\"post\" action=\"CRUDEditorial?action=eliminar\">\n");
      out.write("                                    <input type=\"hidden\" name=\"idEditorial\"\n");
      out.write("                                           value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("                                    <button type=\"submit\">Eliminar</button>\n");
      out.write("                                </form>\n");
      out.write("                                ");
 } else {
      out.write("\n");
      out.write("                                <form method=\"post\" action=\"CRUDEditorial?action=recuperar\">\n");
      out.write("                                    <input type=\"hidden\" name=\"idEditorial\"\n");
      out.write("                                           value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("                                    <button type=\"submit\">Recuperar</button>\n");
      out.write("                                </form>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                <form method=\"post\" action=\"actualizarEditorial.jsp\">\n");
      out.write("                                    <input type=\"hidden\" name=\"idEditorial\"\n");
      out.write("                                           value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"nombreEditorial\"\n");
      out.write("                                           value=\"");
      out.print(nombre);
      out.write("\" />\n");
      out.write("                                    <button type=\"submit\">Modificar</button>\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        ");
 } 
      out.write("    \n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-1\" >   \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div><!-- /.container -->\n");
      out.write("\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("        <h1>No tienes permiso para ver esta pagina</h1>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster --> \n");
      out.write("       <script src=\"./bootstrap-3.1.1-dist/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
