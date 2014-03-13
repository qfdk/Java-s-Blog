<%-- 
    Document   : news
    Created on : 2014-3-6, 20:16:04
    Author     : qfdk
--%>

<%@page import="java.util.List"%>
<%@page import="entites.News"%>

<%@include file="include/header.jsp" %>

<div class="contentLeft">	
    <%
        List<News> arrayList = (List<News>) request.getAttribute("news");
        for (News n : arrayList) {
    %>

    <article class="topcontent">	
        <header>
            <h2><a href="UserServlet?action=details&IdBews=<%=n.getIdNews()%>" rel="bookmark" title="Permalink to this POST TITLE"><%=n.getTitle()%></a></h2>
        </header>

        <footer>
            <p class="post-info"> <%=n.getDate()%></p>
        </footer>
            <p><%=n.getContient()%></p>
    </article>

    <%
            }%>

    </div>
        
<%@include  file="include/tools.jsp" %>
<%@include  file="include/footer.jsp" %>
