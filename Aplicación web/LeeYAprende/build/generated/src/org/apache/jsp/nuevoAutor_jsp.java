package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nuevoAutor_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css\">\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.8.3.js\"></script>\n");
      out.write("<script src=\"http://code.jquery.com/ui/1.9.2/jquery-ui.js\"></script>\n");
      out.write("<script src=\"http://harvesthq.github.com/chosen/chosen/chosen.jquery.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"http://harvesthq.github.com/chosen/chosen/chosen.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(function(){\n");
      out.write("    $(\".chzn-select\").chosen();\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<select class=\"chzn-select\" multiple=\"true\" name=\"faculty\" style=\"width:200px;\">\n");
      out.write("        <option value=\"AC\">A</option>\n");
      out.write("        <option value=\"AD\">B</option>\n");
      out.write("        <option value=\"AM\">C</option>\n");
      out.write("        <option value=\"AP\">D</option>\n");
      out.write("</select>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
