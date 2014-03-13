package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import config.Config;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/include/menu.jsp");
  }

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

      out.write(' ');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>JAVA BLOG</title>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"body\">\n");
      out.write("        <a href=\"https://github.com/qfdk\"><img style=\"position: absolute; top: 0; right: 0; border: 0;\" src=\"https://github-camo.global.ssl.fastly.net/e7bbb0521b397edbd5fe43e7f760759336b5e05f/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677265656e5f3030373230302e706e67\" alt=\"Fork me on GitHub\" data-canonical-src=\"https://s3.amazonaws.com/github/ribbons/forkme_right_green_007200.png\"></a>\n");
      out.write("        <header class=\"mainHeader\">\n");
      out.write("            <h1>");
      out.print(Config.TitreduSiteString);
      out.write("</h1>\n");
      out.write("            <!-- <img src=\"img/logo.gif\"> -->\n");
      out.write("            <nav>\n");
      out.write("                ");
      out.write('\n');

    String actionString = "home";
    try {
        actionString = request.getParameter("action");
    } catch (Exception e) {
        response.sendRedirect("UserServlet?action=home");
    }

      out.write("\n");
      out.write("<ul>\n");
      out.write("    ");

        if (actionString.equals("home")) {
    
      out.write("\n");
      out.write("    <li class=\"active\"><a href=\"UserServlet?action=home\">Home</a></li>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("    <li><a href=\"UserServlet?action=home\">Home</a></li>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

        if (actionString.equals("listerNews")) {
    
      out.write("\n");
      out.write("    <li><a class=\"active\" href=\"UserServlet?action=listerNews\">News</a></li>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("    <li><a href=\"UserServlet?action=listerNews\">News</a></li>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    \n");
      out.write("        ");

        if (actionString.equals("listerNava")) {
    
      out.write("\n");
      out.write("    <li ><a href=\"UserServlet?action=listerNava\">Java</a></li>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("    <li><a href=\"UserServlet?action=listerJava\">Java</a></li>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("<!--    <li><a href=\"UserServlet?action=listerNews\">News</a></li>\n");
      out.write("    <li><a href=\"UserServlet?action=listerJava\">Java</a></li>-->\n");
      out.write("    <li><a href=\"UserServlet?action=aubout\">About</a></li>\n");
      out.write("</ul>");
      out.write("\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"mainContent\">");
      out.write('\n');

    out.append("coucou");

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
