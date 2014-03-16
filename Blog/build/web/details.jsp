<%-- 
    Document   : details
    Created on : 2014-3-13, 15:52:53
    Author     : qfdk
--%>

<%@page import="java.util.Date"%>
<%@page import="entites.Commentaire"%>
<%@page import="java.util.List"%>
<%@page import="entites.News"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<script language="JavaScript" type="text/javascript" src="js/ajax.js"></script>
<div class="content">	
    <%
        News n = (News) request.getAttribute("details");
        List<Commentaire> commentaires = (List<Commentaire>) request.getAttribute("commentaires");
    %>

    <article class="topcontent">	
        <header>
            <h2><a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>" rel="bookmark" title="Permalink to this POST TITLE"><%=n.getTitre()%></a></h2>
        </header>
        <span class="label label-info"><i class="icon-time"></i><%= n.getDate()%></span>
        <span class="label label-success"><i class="icon-user"></i><%= commentaires.size()%></span>
        <footer>
            <p class="post-info"> <%=n.getDate()%></p>
        </footer>
        <p><%=n.getContenu()%></p>
    </article>

    <article class="topcontent">
        <%
            if (commentaires.size() == 0) {
        %>
        <p id="insert">Ajouter une commentaire :P</p>
        <%
        } else {
        %>

        <%
            for (Commentaire c : commentaires) {
        %>
        <b>用户名:</b><%=c.getNom()%><br/>
        <b>时间:</b><%=c.getDateCommentaire()%><br/>
        <%=c.getContenu()%><br/>
        <% if (estAdmin) {%>
        <a class="btn btn-small btn-danger" href="AdminControle?action=supprimerCommentaire&idCommentaire=<%=c.getIdCommentaire()%>&IdNews=<%=n.getIdNews()%>">Supprimer</a><br/>
        <%
            }%>
        <hr/>
        <%   }
            }
        %>
        <p id="insert"></p>

    </article>
    <article class="topcontent">
        <!--<form method="POST" action="UserServlet?action=ajouterCommentaire">-->
        <table width="600" border="0" align="center" cellpadding="3" cellspacing="1">  
            <tr>  
                <td width="50">用户名 </td>  
                <td><input name="nom" type="text" id="nom" /></td>  
            </tr>  
            <tr>  
                <td>内容</td>  
                <td><textarea name="contenu" id="contenu"></textarea></td>  
            </tr>
            <input id="IdNews" name="IdNews" value="<%=n.getIdNews()%>" hidden="true"/>
            <input id="time" name="time" value="<%=new Date(System.currentTimeMillis())%>" hidden="true"/>
            <tr>  
                <td colspan="2"><input name="submit" id="submit" type="submit" value="提交" /></td>  
            </tr>  
        </table> 
        <!--</form>-->
    </article>

</div>

<%@include  file="include/tools.jsp" %>
<%@include  file="include/footer.jsp" %>
