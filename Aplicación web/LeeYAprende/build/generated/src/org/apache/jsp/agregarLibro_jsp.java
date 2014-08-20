package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BEAN.Libro;
import DAO.LibroDao;
import BEAN.Area;
import DAO.AreaDao;
import BEAN.Editorial;
import DAO.EditorialDao;
import BEAN.Autor;
import java.util.List;
import DAO.AutorDao;

public final class agregarLibro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    boolean admin = (Boolean) session.getAttribute("admin");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <title>Biblioteca</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"./images/logo2.png\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-3.1.1-dist/css/bootstrap.min.css\">               \t\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/dataTables.bootstrap.css\">\t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>              \t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.dataTables.js\"></script>\t\t\n");
      out.write("        <script type=\"text/javascript\" src=\"js/dataTables.bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("        <script language=\"JavaScript\" type=\"text/javascript\">\n");
      out.write("            function sortlist(list) {\n");
      out.write("                var lb = document.getElementById(list);\n");
      out.write("                arrTexts = new Array();\n");
      out.write("\n");
      out.write("                for (i = 0; i < lb.length; i++) {\n");
      out.write("                    arrTexts[i] = lb.options[i].text;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                arrTexts.sort();\n");
      out.write("\n");
      out.write("                for (i = 0; i < lb.length; i++) {\n");
      out.write("                    lb.options[i].text = arrTexts[i];\n");
      out.write("                    lb.options[i].value = arrTexts[i];\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
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
      out.write("        </script>  ");
      out.write("\n");
      out.write("\n");
      out.write("        <link href=\"./css/colores.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/estilos.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"./css/nav.css\" rel=\"stylesheet\">   \n");
      out.write("        <link rel=\"stylesheet\" href=\"chosen/chosen.css\">\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("            function validate(form) {\n");
      out.write("                var e = form.elements;\n");
      out.write("                var m = '';\n");
      out.write("\n");
      out.write("                if (e['titulo'].value == null || e['titulo'].value == \"\") {m += '- El titulo es obligatorio.\\n';}\n");
      out.write("                if (e['isbn'].value == null || e['isbn'].value == \"\") {m += '- El ISBN es obligatorio.\\n';}\n");
      out.write("                if (e['pags'].value == null || e['pags'].value == \"\") {m += '- El numero de paginas es obligatorio.\\n';}\n");
      out.write("                if (e['autor'].value == null || e['autor'].value == \"\") {m += '- Debe ingresar por lo menos 1 autor.\\n';}\n");
      out.write("                if (e['editorial'].value == null || e['editorial'].value == \"\") {m += '- La editorial es obligatoria.\\n';}\n");
      out.write("                if (e['area'].value == null || e['area'].value == \"\") {m += '- El area es obligatorio.\\n';}\n");
      out.write("   \n");
      out.write("                if (e['titulo'].value.length > 45) {m += '- El titulo es demasiado largo.\\n';}\n");
      out.write("                if (e['isbn'].value.length > 17) {m += '- El isbn no deberia tener mas de 17 caracteres\\n';}\n");
      out.write("                if (e['pags'].value.length > 45) {m += '- Son demasiadas paginas.\\n';}\n");
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
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" charset=\"utf-8\">\n");
      out.write("function cargarSelect()\n");
      out.write("{\n");
      out.write("                var editoriales = document.getElementById(\"EDITORIALES\").value;\n");
      out.write("                var ids = document.getElementById(\"IDS\").value;\n");
      out.write("                var estados = document.getElementById(\"ESTADOS\").value;\n");
      out.write("                \n");
      out.write("                var editorial = editoriales.split(\",\");\n");
      out.write("                var id = ids.split(\",\");\n");
      out.write("                var estado = estados.split(\",\");\n");
      out.write("                \n");
      out.write("                var x = document.getElementById(\"edit\");\n");
      out.write("                var j = 1;\n");
      out.write("                \n");
      out.write("                for (i = 0; i < editorial.length-1; i++) {\n");
      out.write("                    if (estado[i]==\"true\") {\n");
      out.write("                        x.options[j] = new Option(editorial[i], id[i]);\n");
      out.write("                        j++;\n");
      out.write("                    }\n");
      out.write("                }        \n");
      out.write("\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
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
      out.write("            <div class=\"col-md-10 cuerpo\">\n");
      out.write("\n");
      out.write("                <!--Inicia formulario-->\n");
      out.write("\n");
      out.write("                <form form class=\"form-horizontal\" action=\"CRUDLibro?action=insertar\" method=\"post\" onsubmit=\"return validate(this);\" accept-charset=\"ISO-8859-1\">\n");
      out.write("                    <fieldset>\n");
      out.write("\n");
      out.write("                        <!-- Form Name -->\n");
      out.write("                        <legend>Agregar un libro</legend>                       \n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"titulo\">Titulo</label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"titulo\" name=\"titulo\" type=\"text\" placeholder=\"campo requerido*\" class=\"form-control input-md\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"isbn\">ISBN</label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"isbn\" name=\"isbn\" type=\"text\" placeholder=\"campo requerido*\" class=\"form-control input-md\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Text input-->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"pags\">Numero de paginas</label>  \n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <input id=\"pags\" name=\"pags\" type=\"text\" placeholder=\"campo requerido*\" class=\"form-control input-md\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Select Basic -->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"autor\">Autores</label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <select  id=\"autor\" name=\"autor\"\n");
      out.write("                                         data-placeholder=\"-\" style=\"width:286px;\"\n");
      out.write("                                         multiple class=\"chosen-select\" tabindex=\"11\">\n");
      out.write("                                    <option value=\"\"></option>\n");
      out.write("                                    ");

                                        AutorDao autor = new AutorDao();
                                        List<Autor> autores = autor.consultar();

                                        for (int i = 0; i < autores.size(); i++) {

                                            Autor temporal = autores.get(i);
                                            String nombre = temporal.getNombre();
                                            String paterno = temporal.getApaterno();
                                            int id = temporal.getIdAutor();
                                            if(temporal.isEstado()){
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(id);
      out.write('"');
      out.write('>');
      out.print(nombre + " " + paterno);
      out.write("</option>\n");
      out.write("                                    ");
 }} 
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2\">\n");
      out.write("                                <a href=\"./agregarAutor.jsp\" target=\"_blank\" class=\"link col-md-12\"\n");
      out.write("                                   style=\"margin-top: 6px;\">Nuevo autor</a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Select Basic -->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"editorial\">Editorial</label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                \n");
      out.write("                                <select id=\"edit\" name=\"edit\" class=\"form-control\" onchange=\"cargarSelect();\">                                   \n");
      out.write("                                    ");

                                        EditorialDao dao = new EditorialDao();
                                        List<Editorial> editoriales = dao.consultar();
                                        
                                        String nombres = "";
                                        String ids = "";
                                        String estados = "";

                                        for (int i = 0; i < editoriales.size(); i++) {

                                            Editorial temporal = editoriales.get(i);
                                            
                                            nombres += temporal.getNombre()+",";
                                            ids += temporal.getIdEditorial()+",";
                                            estados += temporal.isEstado()+",";
                                        }    
                                    
      out.write("\n");
      out.write("                                    <option value=\"0\">Seleccione</option>    \n");
      out.write("                                </select>\n");
      out.write("                                    <input type=\"hidden\" id=\"EDITORIALES\" name=\"editoriales\" value=\"");
      out.print(nombres);
      out.write("\" >\n");
      out.write("                                    <input type=\"hidden\" id=\"IDS\" name=\"aidis\" value=\"");
      out.print(ids);
      out.write("\" >\n");
      out.write("                                    <input type=\"hidden\" id=\"ESTADOS\" name=\"estados\" value=\"");
      out.print(estados);
      out.write("\" >\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-3\">\n");
      out.write("                                <a href=\"./agregarEditorial.jsp\" target=\"_blank\" class=\"link col-md-12\"\n");
      out.write("                                   style=\"margin-top: 6px;\">Nueva editorial</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Select Basic -->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"area\">Area</label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <select id=\"area\" name=\"area\" class=\"form-control\">\n");
      out.write("                                    ");

                                        AreaDao edao = new AreaDao();
                                        List<Area> areas = edao.consultar();

                                        for (int i = 0; i < areas.size(); i++) {

                                            Area temporal = areas.get(i);
                                            String nombre = temporal.getNombreArea();
                                            int id = temporal.getIdAreas();
                                            if(temporal.isEstado()){
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(id);
      out.write('"');
      out.write('>');
      out.print(nombre);
      out.write("</option>\n");
      out.write("                                    ");
 }} 
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-2\">\n");
      out.write("                                <a href=\"./agregarArea.jsp\" target=\"_blank\" class=\"link col-md-12\"\n");
      out.write("                                   style=\"margin-top: 6px;\">Nueva área</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Button -->\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\" for=\"enviar\"></label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <button id=\"enviar\" name=\"enviar\" class=\"btn btn-default\">Agregar</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </fieldset>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!-- Termina formulario-->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <table id=\"tabla\" class=\"table table-striped table-bordered\" style=\"font-size: small;\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ISBN</th>\n");
      out.write("                            <th>Titulo</th>\n");
      out.write("                            <th>Autor</th>\n");
      out.write("                            <th>Estado</th>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");

                            LibroDao Dao = new LibroDao();
                            List<Libro> libros = Dao.consultar();

                            for (int i = 0; i < libros.size(); i++) {
                                Libro temporal = libros.get(i);
                                

                                String estado;
                                String nautor = temporal.getAutor().getNombre() + " " + temporal.getAutor().getApaterno();

                                for (int j = i+1; j < libros.size(); j++) {
                                    Libro compara = libros.get(j);
                                    
                                    if (temporal.getIsbn().equals(compara.getIsbn())) {

                                        nautor = nautor + ", " + compara.getAutor().getNombre() + " " + compara.getAutor().getApaterno();
                                        i=i+1;
                                    }
                                }
                                
                                String isbn = temporal.getIsbn();
                                String titulo = temporal.getTitulo();
                                int paginas = temporal.getNum_paginas();
                                String editorial = temporal.getEditorial().getNombre();
                                String area = temporal.getArea().getNombreArea();
                                int id = temporal.getIdLibro();

                                if (temporal.isMostrar()) {
                                    estado = "Activo";
                                } else {
                                    estado = "Inactivo";
                                }


                        
      out.write("        \n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(isbn);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(titulo);
      out.write("</td>                      \n");
      out.write("                            <td>");
      out.print(nautor);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(estado);
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                ");
 if (estado.equals("Activo")) {
      out.write("\n");
      out.write("                                <form method=\"post\" action=\"CRUDLibro?action=eliminar\">\n");
      out.write("                                    <input type=\"hidden\" name=\"id\"\n");
      out.write("                                           value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("                                    <button type=\"submit\">Eliminar</button>\n");
      out.write("                                </form>\n");
      out.write("                                ");
 } else {
      out.write("\n");
      out.write("                                <form method=\"post\" action=\"CRUDLibro?action=recuperar\">\n");
      out.write("                                    <input type=\"hidden\" name=\"id\"\n");
      out.write("                                           value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("                                    <button type=\"submit\">Recuperar</button>\n");
      out.write("                                </form>\n");
      out.write("                                ");
 }
      out.write("                               \n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                <form method=\"post\" action=\"actualizarLibro.jsp\" accept-charset=\"ISO-8859-1\">\n");
      out.write("                                    <input type=\"hidden\" name=\"isbn\" value=\"");
      out.print(isbn);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"titulo\" value=\"");
      out.print(titulo);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"numpag\" value=\"");
      out.print(paginas);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"autor\" value=\"");
      out.print(nautor);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"editorial\" value=\"");
      out.print(editorial);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"area\" value=\"");
      out.print(area);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"mostrar\" value=\"");
      out.print(estado);
      out.write("\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\" />\n");
      out.write("                                    <button type=\"submit\">Modificar</button>\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-1\">   \n");
      out.write("            </div>\n");
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
      out.write("\n");
      out.write("        </div>       \n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("\n");
      out.write("        <script src=\"./bootstrap-3.1.1-dist/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        ");
      out.write("       \n");
      out.write("\n");
      out.write("        <script src=\"chosen/chosen.jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"chosen/docsupport/prism.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        var config = {\n");
      out.write("            '.chosen-select': {no_results_text: 'No hay resultados para:', width: \"100%\"}\n");
      out.write("        }\n");
      out.write("        for (var selector in config) {\n");
      out.write("            $(selector).chosen(config[selector]);\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
