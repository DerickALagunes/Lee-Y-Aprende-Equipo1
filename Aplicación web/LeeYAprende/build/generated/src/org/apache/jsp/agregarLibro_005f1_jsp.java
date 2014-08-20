package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agregarLibro_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("/**\n");
      out.write(" * Funcion que se ejecuta al seleccionar una opcion del primer select\n");
      out.write(" */\n");
      out.write("function cargarSelect2(valor)\n");
      out.write("{\n");
      out.write("    /**\n");
      out.write("     * Este array contiene los valores sel segundo select\n");
      out.write("     * Los valores del mismo son:\n");
      out.write("     *  - hace referencia al value del primer select. Es para saber que valores\n");
      out.write("     *  mostrar una vez se haya seleccionado una opcion del primer select\n");
      out.write("     *  - value que se asignara\n");
      out.write("     *  - testo que se asignara\n");
      out.write("     */\n");
      out.write("    var arrayValores=new Array(\n");
      out.write("        new Array(1,1,\"opcion1-1\"),\n");
      out.write("        new Array(1,2,\"opcion1-2\"),\n");
      out.write("        new Array(1,3,\"opcion1-3\"),\n");
      out.write("        new Array(2,1,\"opcion2-1\"),\n");
      out.write("        new Array(3,1,\"opcion3-1\"),\n");
      out.write("        new Array(3,2,\"opcion3-2\"),\n");
      out.write("        new Array(3,3,\"opcion3-3\"),\n");
      out.write("        new Array(3,4,\"opcion3-4\")\n");
      out.write("    );\n");
      out.write("    if(valor==0)\n");
      out.write("    {\n");
      out.write("        // desactivamos el segundo select\n");
      out.write("        document.getElementById(\"select2\").disabled=true;\n");
      out.write("    }else{\n");
      out.write("        // eliminamos todos los posibles valores que contenga el select2\n");
      out.write("        document.getElementById(\"select2\").options.length=0;\n");
      out.write("        \n");
      out.write("        // añadimos los nuevos valores al select2\n");
      out.write("        document.getElementById(\"select2\").options[0]=new Option(\"Selecciona una opcion\", \"0\");\n");
      out.write("        for(i=0;i<arrayValores.length;i++)\n");
      out.write("        {\n");
      out.write("            // unicamente añadimos las opciones que pertenecen al id seleccionado\n");
      out.write("            // del primer select\n");
      out.write("            if(arrayValores[i][0]==valor)\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"select2\").options[document.getElementById(\"select2\").options.length]=new Option(arrayValores[i][2], arrayValores[i][1]);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        // habilitamos el segundo select\n");
      out.write("        document.getElementById(\"select2\").disabled=false;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("</body>\n");
      out.write("<form>\n");
      out.write("    <p>\n");
      out.write("        <select id='select1' onclick='cargarSelect2(this.value);'>\n");
      out.write("            <option value='0'>Selecciona una opcion</option>\n");
      out.write("            <option value='1'>opcion 1</option>\n");
      out.write("            <option value='2'>opcion 2</option>\n");
      out.write("            <option value='3'>opcion 3</option>\n");
      out.write("        </select>\n");
      out.write("    </p>\n");
      out.write("    \n");
      out.write("    <p>\n");
      out.write("        <select id='select2' onchange='seleccinado_select2();' disabled>\n");
      out.write("            <option value='0'>Selecciona una opcion</option>\n");
      out.write("        </select>\n");
      out.write("    </p>\n");
      out.write("</form>\n");
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
