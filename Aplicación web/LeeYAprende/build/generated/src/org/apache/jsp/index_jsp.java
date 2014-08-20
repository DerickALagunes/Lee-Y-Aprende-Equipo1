package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BEAN.Editorial;
import DAO.ConsultasDao;
import BEAN.Libro;
import java.util.List;
import DAO.LibroDao;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"error.jsp", true, 8192, true);
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
      out.write("\n");
      out.write("\n");

    HttpSession sesion = request.getSession();
    sesion.setAttribute("admin", false)
    sesion.setAttribute("user", false);

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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-3.1.1-dist/css/bootstrap.min.css\">               \t\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/dataTables.bootstrap.css\">\t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>              \t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.dataTables.js\"></script>\t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/dataTables.bootstrap.js\"></script>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("            $(document).ready(function() {\n");
      out.write("                $('#tabla').dataTable({\n");
      out.write("                    \"lengthMenu\": [[10, 25, 50, -1], [10, 25, 50, \"Todo\"]],\n");
      out.write("                    \"pagingType\": \"full_numbers\",\n");
      out.write("                    \"language\": {\n");
      out.write("                        \"emptyTable\": \"No hay datos disponibles en la tabla\",\n");
      out.write("                        \"info\": \" _START_ a _END_ de un total de _TOTAL_ registros\",\n");
      out.write("                        \"infoEmpty\": \"Ningún registro\",\n");
      out.write("                        \"search\": \"Busqueda de libros:  _INPUT_\",\n");
      out.write("                        \"zeroRecords\": \"No hay registros para mostrar, intente agregar a su busqueda simbolos -,?,!\",\n");
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
      out.write("        <link href=\"./css/colores.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/nav.css\" rel=\"stylesheet\">   \n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("            function validate2(form) {\n");
      out.write("                var e = form.elements;\n");
      out.write("                var titulos = e['titulos'].value;\n");
      out.write("                var estados = e['estados'].value;\n");
      out.write("                var registros = e['registros'].value;\n");
      out.write("                var mensaje='';\n");
      out.write("                \n");
      out.write("                if (registros==\"true\") {\n");
      out.write("                    \n");
      out.write("                    var titulo = titulos.split(\",\");\n");
      out.write("                    var estado = estados.split(\",\");\n");
      out.write("                    \n");
      out.write("                    for (i = 0; i < titulo.length-1; i++) {\n");
      out.write("                        \n");
      out.write("                        if (estado[i]==\"true\") {\n");
      out.write("                            mensaje += \"-\"+titulo[i]+\".\\n\";\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    alert(\"Libros con mayor existencia en la biblioteca: \\n\\n\"+mensaje);\n");
      out.write("                    \n");
      out.write("                }else{\n");
      out.write("                    alert(\"No hay libros en la biblioteca\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("            function validate(form) {\n");
      out.write("                var e = form.elements;\n");
      out.write("                var editoriales = e['editoriales'].value;\n");
      out.write("                var estados = e['estadose'].value;\n");
      out.write("                var registros = e['registrose'].value;\n");
      out.write("                var mensaje='';\n");
      out.write("                \n");
      out.write("                if (registros==\"true\") {\n");
      out.write("                    \n");
      out.write("                    var editorial = editoriales.split(\",\");\n");
      out.write("                    var estado = estados.split(\",\");\n");
      out.write("                    \n");
      out.write("                    for (i = 0; i < editorial.length-1; i++) {\n");
      out.write("                        \n");
      out.write("                        if (estado[i]==\"true\") {\n");
      out.write("                            mensaje += \"-\"+editorial[i]+\".\\n\";\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    alert(\"Editoriales con menor existencia en la biblioteca: \\n\\n\"+mensaje);\n");
      out.write("                    \n");
      out.write("                }else{\n");
      out.write("                    alert(\"No hay editoriales en la biblioteca\");\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
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
      out.write("                    <img src=\"images/logolyp.png\" alt=\"logo\"/><a class=\"navbar-brand\">Lee y Aprende</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar-collapse collapse\">\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"./index.jsp\">Inicio</a></li>               \n");
      out.write("                    </ul>\n");
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
      out.write("\n");
      out.write("                </div><!--/.navbar-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"padding-top: 45px; padding-bottom: 80px\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"col-md-12 cuerpo\">\n");
      out.write("                <div class=\"col-md-6 cuerpo\">\n");
      out.write("                    <h1>Biblioteca Lee y Aprende</h1>\n");
      out.write("                    <legend><p class=\"lead\">Bienvenido al sistema de biblioteca</p></legend>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-offset-2 col-md-4\">\n");
      out.write("                    <br />\n");
      out.write("                    <form onsubmit=\"return validate2(this);\">\n");
      out.write("                        ");
 
                        ConsultasDao consultar = new ConsultasDao();
                        List<Libro> rs = consultar.librosConMayorExistencia();
                        String titulos="";
                        String estados="";
                        boolean registros=false;
                        
                        if(rs.size()>0){
                            registros=true;
                            
                            for (int i = 0; i < rs.size(); i++) {
                                Libro temporal = rs.get(i);
                                
                                boolean estado = temporal.isMostrar();
                                String titulo = temporal.getTitulo();
                                
                                titulos += titulo+",";    
                                estados += estado+","; 
                                
                            }
                        }
                        
      out.write("\n");
      out.write("                    <p class=\"lead\">Libro con mas existencias:<button type=\"submit\" class=\"btn btn-default\">Buscar</button></p>\n");
      out.write("                    <input type=\"hidden\" name=\"titulos\" value=\"");
      out.print(titulos);
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"estados\" value=\"");
      out.print(estados);
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"registros\" value=\"");
      out.print(registros);
      out.write("\">\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <form onsubmit=\"return validate(this)\">\n");
      out.write("                        ");
 
                        List<Editorial> rse = consultar.editorialesConMenorExistencia();
                        String editoriales="";
                        String estadose="";
                        boolean registrose=false;
                        
                        if(rse.size()>0){
                            registrose=true;
                            
                            for (int i = 0; i < rse.size(); i++) {
                                Editorial temp = rse.get(i);
                                
                                boolean estado = temp.isEstado();
                                String nombre = temp.getNombre();
                                
                                editoriales += nombre+",";    
                                estadose += estado+",";   
                                
                            }
                        }
                        
      out.write("\n");
      out.write("                    <p class=\"lead\">Editorial con menos libros :<button type=\"submit\" class=\"btn btn-default\">Buscar</button></p>       \n");
      out.write("                    <input type=\"hidden\" name=\"editoriales\" value=\"");
      out.print(editoriales);
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"estadose\" value=\"");
      out.print(estadose);
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"registrose\" value=\"");
      out.print(registrose);
      out.write("\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                                    \n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <br/>\n");
      out.write("                </div>\n");
      out.write("                                    \n");
      out.write("                <table id=\"tabla\" class=\"table table-striped table-bordered\" style=\"font-size: small;\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ISBN</th>\n");
      out.write("                            <th>Título</th>\n");
      out.write("                            <th>No. de páginas</th>\n");
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
                                String nautor = "Autor no disponible";
                                if (temporal.getAutor().isEstado()) {
                                        nautor = temporal.getAutor().getNombre() + " " + temporal.getAutor().getApaterno();
                                    }             

                                for (int j = i+1; j < libros.size(); j++) {
                                    Libro compara = libros.get(j);
                                    
                                    if (temporal.getIsbn().equals(compara.getIsbn())) {
                                        
                                        if (compara.getAutor().isEstado()) {
                                                nautor = nautor + " , " + compara.getAutor().getNombre() + " " + compara.getAutor().getApaterno();
                                        }else{
                                            nautor = nautor + " , Autor no disponible";
                                        }
         
                                        i=i+1;
                                    }
                                }
                                
                                String isbn = temporal.getIsbn();
                                String titulo = temporal.getTitulo();
                                int paginas = temporal.getNum_paginas();
                                //mostrar inactividad si se borran(tambien autor
                                String editorial = "Editorial no disponible.";
                                String area = "Área no disponible.";
                                if (temporal.getEditorial().isEstado()) {
                                        editorial = temporal.getEditorial().getNombre();
                                    }
                                if (temporal.getArea().isEstado()) {
                                        area = temporal.getArea().getNombreArea();
                                    }  
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
