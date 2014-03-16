<%@page import="entites.Admin"%>
<%@page import="config.Config" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JAVA BLOG</title>
        <meta charset="utf-8" />
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css" type="text/css" />
        <script src="./js/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="body">
        <a href="https://github.com/qfdk"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://github-camo.global.ssl.fastly.net/e7bbb0521b397edbd5fe43e7f760759336b5e05f/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677265656e5f3030373230302e706e67" alt="Fork me on GitHub" data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_right_green_007200.png"></a>
        <header class="mainHeader">
            <h1><%=Config.TitreduSiteString%></h1>
            <!-- <img src="img/logo.gif"> -->
            <nav>
                <%--<%@include  file="menu.jsp" %>--%>
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
                        <%if (estAdmin) {
                        %>
                    <li><a href="AdminControle?action=admin">Admin</a></li>
                        <%} else {%>
                    <li><a href="UserServlet?action=aubout">About</a></li>
                        <%
            }%>
               
                </ul>
    <form class="navbar-form pull-left" method="POST" action="UserServlet?action=rechercher">
    <input type="text" name="motcle" class="span2">
    <input type="submit" class="btn" value="Recherche" />
    </form>
            </nav>
        </header>
        <div class="mainContent">