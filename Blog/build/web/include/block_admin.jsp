<%-- 
    Document   : adminBlock
    Created on : 2014-3-13, 23:20:04
    Author     : qfdk
--%>
<%@page import="entites.Admin"%>
<aside class="top-sidebar">
    <article>
        <%
            if (estAdmin) {
        %>
        <h2><b>Wellcomme back,</b><%= admin.getLogin()%></h2>
        <a class="btn btn-danger" href="AdminControle?action=logout">logout</a>
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
        %>

    </article>
</aside>
