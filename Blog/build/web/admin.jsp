<%-- 
    Document   : news
    Created on : 2014-3-6, 20:16:04
    Author     : qfdk
--%>

<%@page import="java.util.List"%>
<%@page import="entites.News"%>
<%@include file="/include/header.jsp" %>
<div class="content">
    <article class="topcontent">	
        <table class="table table-condensed">
            <thead>
            <th>Title</th>
            <th>Date</th>
            <th></th>
            <th><a class="btn btn-danger" href="./formulaire.jsp?action=home">Nouveu</a></th>
            </thead>
            <%
                List<News> arrayList = (List<News>) request.getAttribute("home");
                for (News n : arrayList) {
            %>
            <tr>
                <td>
                    <a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>" rel="bookmark" title="Permalink to this POST TITLE">
                        <b><%=n.getTitre()%></b></a>
                </td>
                <td><%=n.getDate()%></td>
                <td></td>
                <td>              
                    <div class="btn-group">
                        <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Action<span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>">Lire</a></li>
                            <li><a href="AdminControle?action=affichierNews&IdNews=<%=n.getIdNews()%>">Modifier</a></li>
                            <li><a href="AdminControle?action=supprimer&IdNews=<%=n.getIdNews()%>">Supprimer</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
            <%
                }%>
        </table>
    </article>
</div>

<%@include  file="/include/tools.jsp" %>
<%@include  file="/include/footer.jsp" %>
