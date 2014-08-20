package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class actualizarAutor_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    boolean admin = (Boolean) session.getAttribute("admin");

      out.write("\n");
      out.write("\n");
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
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"./bootstrap-3.1.1-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/colores.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/nav.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("            function validate(form) {\n");
      out.write("                var e = form.elements;\n");
      out.write("                var m = '';\n");
      out.write("\n");
      out.write("                if (e['nombre'].value == null || e['nombre'].value == \"\") {m += '- Porfavor ingrese el nombre del autor.\\n';}\n");
      out.write("                if (e['nombre'].value.length > 45) {m += '- El nombre del autor es demasiado largo\\n';}\n");
      out.write("                if (e['paterno'].value.length > 45) {m += '- El nombre del autor es demasiado largo\\n';}\n");
      out.write("                if (e['materno'].value.length > 45) {m += '- El nombre del autor es demasiado largo\\n';}\n");
      out.write("\n");
      out.write("                if (m) {\n");
      out.write("                    alert('Error: \\n\\n' + m);\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        ");
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
      out.write("                <div class=\"collapse navbar-collapse\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"./inicio.jsp\">Inicio</a></li>\n");
      out.write("                        <li><a href=\"./administrador.jsp\">Herramientas Adm</a></li>\n");
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
      out.write("        <div class=\"container\" style=\"padding-top: 45px;\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-1\">   \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-10 cuerpo\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Form Start -->\n");
      out.write("\n");
      out.write("                <form class=\"form-horizontal\" method=\"post\" action=\"CRUDAutor?action=modificar\" accept-charset=\"ISO-8859-1\" onsubmit=\"return validate(this);\">\n");
      out.write("                    <fieldset>\n");
      out.write("\n");
      out.write("                        <!-- Form Name -->\n");
      out.write("                        <legend>Modificar un autor</legend>\n");
      out.write("\n");
      out.write("                        ");


                            String nombre = request.getParameter("nombre");
                            String paterno = request.getParameter("paterno");
                            String materno = request.getParameter("materno");
                            String id = request.getParameter("id");

                        
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"nombre\">Modificación:</label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"nombre\" name=\"nombre\" type=\"text\" \n");
      out.write("                                       class=\"form-control input-md\" required=\"\"\n");
      out.write("                                       value=\"");
      out.print(nombre);
      out.write("\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"paterno\"></label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"paterno\" name=\"paterno\" type=\"text\" class=\"form-control input-md\"\n");
      out.write("                                       value=\"");
      out.print(paterno);
      out.write("\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"materno\"></label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"materno\" name=\"materno\" type=\"text\" class=\"form-control input-md\"\n");
      out.write("                                       value=\"");
      out.print(materno);
      out.write("\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"id\"\n");
      out.write("                               value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Button -->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"insertar\"></label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <button id=\"insertar\" name=\"insertar\" class=\"btn btn-default\">Modificar</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </fieldset>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!-- Termina formulario-->\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div class=\"col-md-1\">   \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div><!-- /.container -->\n");
      out.write("\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("            <h1>No tienes permiso para ver esta pagina</h1>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Bootstrap core JavaScript\n");
      out.write("            ================================================== -->\n");
      out.write("            <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("            <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("            <script src=\"./bootstrap-3.1.1-dist/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div class=\"navbar navbar-default navbar-fixed-bottom\">\n");
      out.write("\n");
      out.write("                <div class=\"container\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav\">    \n");
      out.write("                        <li>\n");
      out.write("                            <img src=\"./images/logo2.png\" />\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"./equipo.jsp\">© 2014 – 2020 Blue Software Desing - Lee Y Aprende</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right \">\n");
      out.write("                        <li><a href=\"./contacto.jsp\">Contacto</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
