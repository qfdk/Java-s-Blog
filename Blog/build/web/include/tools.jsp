<%@page contentType="text/html" pageEncoding="UTF-8"%><aside class="top-sidebar">    <article>        <%            if (estAdmin) {        %>        <h2><b>Wellcome back,</b><%= admin.getLogin()%></h2>        <a class="btn btn-danger" href="AdminControle?action=logout">logout</a>        <%        } else {        %>          <form action="AdminControle?action=login" method="POST">		            <label class="control-label" for="login">Login:</label>             <input type="text" name="login" placeholder="UserName"/>            <label for="mdp">Password:</label>             <input type="password" name="mdp" placeholder="Password"/>            <button id="btn" type="submit" class="btn btn-primary">Sign in</button>        </form>                 <%            }        %>    </article></aside><aside class="middle-sidebar">    <article>        <h2>Tags</h2>        <p>            <a href="UserServlet?action=listerNews">                <span class="label label-success"><i class="icon-tags"></i> News</span></a>            <a href="UserServlet?action=listerJava">                <span class="label label-warning"><i class="icon-tags"></i> Java</span></a>            <span class="label label-important">Important</span>            <span class="label label-info">Info</span>        </p>    </article></aside><aside class="middle-sidebar">    <article>        <h2>Compteur</h2>        <p>            <span class="label"><i class="icon-comment"></i> <%= request.getAttribute("nbcommentaires") %></span>            <span class="label label-info"><i class="icon-user"></i> <%= request.getAttribute("nbclient") %></span>        </p>    </article></aside><aside class="bottom-sidebar">    <article>        <h2>Links</h2>        <ul>             <li><a href="http://blog.qfdk.me">qfdk'S Blog</a></li>            <li><a href="http://qfdk.github.io">Mes projets</a></li>        </ul>     </article></aside>	