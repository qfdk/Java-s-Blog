<%@page import="entites.Admin"%>
<%
    Admin admin = null;
    boolean estAdmin;
    try {
        estAdmin = ((Boolean) session.getAttribute("estAdmin")).booleanValue();
        admin = (Admin) session.getAttribute("admin");
    } catch (NullPointerException e) {
        estAdmin = false;
    } catch (Exception e) {
        estAdmin = false;
    }

    String actionString = "home";
    try {
        actionString = request.getParameter("action");

%>
<ul>
    <%        if (actionString.equals("home")) {
    %>
    <li class="active"><a href="UserServlet?action=home">Home</a></li>
        <%} else {%>
    <li><a href="UserServlet?action=home">Home</a></li>
        <%
            }
        %>

    <%
        if (actionString.equals("listerNews")) {
    %>
    <li class="active" ><a href="UserServlet?action=listerNews">News</a></li>
        <%} else {%>
    <li><a href="UserServlet?action=listerNews">News</a></li>
        <%
            }
        %>

    <%
        if (actionString.equals("listerJava")) {
    %>
    <li class="active"><a href="UserServlet?action=listerJava">Java</a></li>
        <%} else {%>
    <li><a href="UserServlet?action=listerJava">Java</a></li>
        <%
            }
        } catch (Exception e) {
        %>
    <li><a href="UserServlet?action=home">404,Cette page ne trouve pas,cliquez ici :P</a></li>
        <%
            }
        %>
        <%if(estAdmin){
            %>
        <li><a href="AdminControle?action=admin">Admin</a></li>
            <%}else{%>
        <li><a href="UserServlet?action=aubout">About</a></li>
        <%
        }%>

</ul>
<!--<form class="navbar-form pull-right" method="POST" action="UserServlet?action=rechercher">
    <input type="text" name="motcle" class="span2">
    <input type="submit" class="btn" value="Recherche" />
</form>-->