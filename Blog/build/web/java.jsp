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
        List<News> arrayList = (List<News>) request.getAttribute("java");
        List<News> allNewses = (List<News>) request.getAttribute("all");
        Integer nbpageInteger = Integer.parseInt(request.getParameter("NumPage"));
        int maxI = allNewses.size() / Config.NB_NEWS_MAX + 1;
        if (maxI <= 2) {
            maxI = 1;
        }
        for (News n : arrayList) {
    %>

    <article class="topcontent">	
        <header>
            <h2><a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>" rel="bookmark" title="Permalink to this POST TITLE"><%=n.getTitre()%></a></h2>
        </header>

        <footer>
            <p class="post-info"> <i class="icon-time"></i><%=n.getDate()%>

            </p>
        </footer>
        <p><%=n.getContenu()%></p>

        <a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>"><span class="label">More...</span></a>
    </article>

    <%
        }%>
    <ul class="pager">
        <li><a href="UserServlet?action=listerJava&NumPage=<%=nbpageInteger - 1%>">Previous</a></li>
            <%
                if (nbpageInteger >= maxI) {
            %>
        <li><a href="UserServlet?action=listerJava&NumPage=<%=maxI%>">Next</a></li>
            <%
            } else {%>
        <li><a href="UserServlet?action=listerJava&NumPage=<%=nbpageInteger + 1%>">Next</a></li>
            <%
                }

            %>


    </ul>
</div>

<%@include  file="include/tools.jsp" %>
<%@include  file="include/footer.jsp" %>
