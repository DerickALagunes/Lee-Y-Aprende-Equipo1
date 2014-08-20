package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class equipo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"./bootstrap-3.1.1-dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link href=\"./css/colores.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/nav.css\" rel=\"stylesheet\">\n");
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
      out.write("                    <a class=\"navbar-brand\"><img src=\"images/logolyp.png\" alt=\"logo\"/>Lee y Aprende</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-collapse collapse\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"./inicio.jsp\">Inicio</a></li>\n");
      out.write("                    </ul>\n");
      out.write("  \n");
      out.write("                </div><!--/.navbar-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"padding-top: 45px;\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-1\">   \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-10 cuerpo\">\n");
      out.write("                \n");
      out.write("                <legend><h1>Biblioteca Lee y Aprende</h1></legend>                          \n");
      out.write("               \n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <p></p>\n");
      out.write("                    <p></p>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-7\">\n");
      out.write("                    <strong><h4>Desarrolladores:</h4></strong>\n");
      out.write("                <table class=\"contacto\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Nombre</th>\n");
      out.write("                            <th>Correo</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Lagunes Ramírez Derick Axel</td>\n");
      out.write("                            <td>axel_lagunes@outlook.com</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Longardo Ynsfran Rosa</td>\n");
      out.write("                            <td>rosaloyns@gmail.com</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Camacho Aréstegui Mariela</td>\n");
      out.write("                            <td>marielacamachoarestegui@gmail.com</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Castillo Sánchez Arturo</td>\n");
      out.write("                            <td>arturo.castillosanchez15@gmail.com</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Rebolledo Uriza Arturo</td>\n");
      out.write("                            <td>goku_masterchief@gmail.com</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-5\">\n");
      out.write("                    <br /><br />\n");
      out.write("                    <img src=\"images/logoequipo.png\" alt=\"equipo.logo\" class=\"col-md-6 hidden-sm hidden-xs\"/>\n");
      out.write("                    <br />\n");
      out.write("                    <img src=\"./images/utez.png\" alt=\"utez.logo\" class=\"col-md-6 hidden-sm hidden-xs\"/>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <p></p>\n");
      out.write("                    <p></p>\n");
      out.write("                </div>      \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-offset-11 col-md-1\">   \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div><!-- /.container -->\n");
      out.write("        \n");
      out.write("        <div class=\"navbar navbar-default navbar-fixed-bottom\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav\">    \n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <a href=\"\">© 2014 - 2020 Blue Software Design - Lee Y Aprende</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right \">\n");
      out.write("                    <li><a href=\"./contacto.jsp\">Contacto</a></li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\n");
      out.write("        <script src=\"./bootstrap-3.1.1-dist/js/bootstrap.min.js\"></script>\n");
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
