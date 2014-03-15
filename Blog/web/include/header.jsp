<%@page import="config.Config" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JAVA BLOG</title>
        <meta charset="utf-8" />
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./style.css" type="text/css" />
        <script src="js/jquery.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="body">
        <a href="https://github.com/qfdk"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://github-camo.global.ssl.fastly.net/e7bbb0521b397edbd5fe43e7f760759336b5e05f/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677265656e5f3030373230302e706e67" alt="Fork me on GitHub" data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_right_green_007200.png"></a>
        <header class="mainHeader">
            <h1><%=Config.TitreduSiteString%></h1>
            <!-- <img src="img/logo.gif"> -->
            <nav>
                <%@include  file="menu.jsp" %>
            </nav>
        </header>
        <div class="mainContent">