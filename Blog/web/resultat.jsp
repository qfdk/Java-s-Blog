<%-- 
    Document   : news
    Created on : 2014-3-6, 20:16:04
    Author     : qfdk
--%>

<%@page import="java.util.List"%>
<%@page import="entites.News"%>

<%@include file="include/header.jsp" %>

<div class="content">	
    <%
        List<News> arrayList = (List<News>) request.getAttribute("key");
        if (arrayList.size() == 0) {
    %>
    <article class="topcontent">
        <img src="img/404.jpg"/> 
        <div class="info">
            <h2>Mince,auchun resultat :P</h2>
        </div>
    </article>
    <%
    } else {
        for (News n : arrayList) {
    %>

    <article class="topcontent">	
        <header>
            <h2><a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>" rel="bookmark" title="Permalink to this POST TITLE"><%=n.getTitre()%></a></h2>
        </header>

        <footer>
            <p class="post-info"> <%=n.getDate()%></p>
        </footer>
        <p><%=n.getContenu()%></p>
    </article>

    <%
            }
        }%>

</div>

<%@include  file="include/tools.jsp" %>
<%@include  file="include/footer.jsp" %>
