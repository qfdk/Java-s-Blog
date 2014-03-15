<%-- 
    Document   : adminBlock
    Created on : 2014-3-13, 23:20:04
    Author     : qfdk
--%>
<%@page import="entites.Admin"%>
<aside class="top-sidebar">
    <article>
        <%
            try {
                Admin admin = (Admin) request.getAttribute("admin");
                if (admin != null) {
        %>
        <h2><b>Wellcomme back,<%= admin.getLogin()%></b></h2>
        <%
        } else {
        %>  

        <form action="AdminControle?action=login" method="POST">		
            <label class="control-label" for="login">Login:</label> 
            <input type="text" name="login" placeholder="UserName"/>
            <label for="mdp">Password:</label> 
            <input type="password" name="mdp" placeholder="Password"/>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>         
        <%
                }
            } catch (Exception e) {

            }
        %>

    </article>
</aside>
