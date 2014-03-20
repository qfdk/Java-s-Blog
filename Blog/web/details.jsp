<%-- 
    Document   : details
    Created on : 2014-3-13, 15:52:53
    Author     : qfdk
--%>

<%@page import="control.MD5Util"%>
<%@page import="java.util.Date"%>
<%@page import="entites.Commentaire"%>
<%@page import="java.util.List"%>
<%@page import="entites.News"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<script language="JavaScript" type="text/javascript" src="js/jquery.md5.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ajax.js"></script>
<div class="content">	
    <%   
        News n = (News) request.getAttribute("details");
        String nomString = (String) session.getAttribute("client");
        if(nomString==null)
            nomString="";
        List<Commentaire> commentaires = (List<Commentaire>) request.getAttribute("commentaires");
    %>

    <article class="topcontent">	
        <header>
            <h2><a href="UserServlet?action=details&IdNews=<%=n.getIdNews()%>" rel="bookmark" title="Permalink to this POST TITLE"><%=n.getTitre()%></a></h2>
        </header>
        <footer>
            <p class="post-info"> <i class="icon-time"></i><%=n.getDate()%>
                <span class="label label-success"><i class="icon-user"></i><%= commentaires.size()%></span>
            </p>
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
        <b>Pseudo:</b><%=c.getNom()%><br/>
        <b>Time:</b><%=c.getDateCommentaire().toString().substring(4, 16)%><br/>
        <img src="http://www.gravatar.com/avatar/<%=MD5Util.md5Hex(c.getNom())%>?s=40"/> <%=c.getContenu()%><br/>
        <% if (estAdmin) {%>
        <a href="AdminControle?action=supprimerCommentaire&idCommentaire=<%=c.getIdCommentaire()%>&IdNews=<%=n.getIdNews()%>">
            <span class="label label-important"><i class="icon-trash"></i> Supprimer</span></a>
            <%   }
            %>
        <hr/>
        <%
                }
            }
        %>
        <p id="insert"></p>

    </article>
    <article class="topcontent">
        <!--<form method="POST" action="UserServlet?action=ajouterCommentaire">-->
        <table width="600" border="0" align="center" cellpadding="3" cellspacing="1">  
            <tr>  
                <td width="50">Pseudo: </td>  
                <td><input name="nom" type="text" id="nom" value="<%=nomString%>"/></td>  
            </tr>  
            <tr>  
                <td>Content: </td>  
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
