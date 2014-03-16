/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import config.Config;
import entites.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.AdminModele;
import modele.UserModele;

/**
 *
 * @author qfdk
 */
@WebServlet(name = "AdminControle", urlPatterns = {"/AdminControle"})
public class AdminControle extends UserServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response); //To change body of generated methods, choose Tools | Templates.
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response); //To change body of generated methods, choose Tools | Templates.
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminControle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String actionString = request.getParameter("action");
            switch (actionString) {
                case "login":
                    login(request, response);
                    break;
                case "ajouter":
                    ajouterNews(request, response);
                    redirection(Config.PAGE_INDEX, request, response);
                    break;
                case "supprimer":
                    supprimer(request, response);
                    break;
                case "supprimerCommentaire":
                    supprimerCommentaire(request, response);
                    break;
                case "affichierNews":
                    affichierNews(request, response);
                    break;
                case "modifier":
                    modifier(request,response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                case "admin":
                    admin(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");

        if (mdp == null || login == null) {
            redirection(Config.PAGE_INDEX, request, response);
        } else if (modeleAdmin.connextion(login, mdp, request)) {
            request.setAttribute("admin", modeleAdmin.getAdmin());
            request.setAttribute("home", modeleAdmin.listerAllNews());
            redirection("admin.jsp", request, response);
        } else {
            redirection(Config.PAGE_INDEX, request, response);
        }
    }

    private void ajouterNews(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        AdminModele modeleAdmin = new AdminModele();
        News neufNews = new News();
        neufNews.setTitre(String2Utf8.converterString(request.getParameter("title")));
        neufNews.setTags(request.getParameter("tags"));
        neufNews.setContenu(String2Utf8.converterString(request.getParameter("contient")));
        neufNews.setDate(new Date(System.currentTimeMillis()));
        modeleAdmin.ajouterNews(neufNews);
    }

    private void supprimer(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        Integer id = Integer.parseInt(request.getParameter("IdNews"));
        modeleAdmin.supprimerAllCommentaire(id);
        modeleAdmin.supprimerNews(id);
        request.setAttribute("admin", modeleAdmin.getAdmin());
        request.setAttribute("home", modeleAdmin.listerAllNews());
        redirection("admin.jsp", request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        try {
            modeleAdmin.seDeconnecter(request);
        } catch (Exception ex) {
            Logger.getLogger(AdminControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        redirection("index.jsp", request, response);
    }

    private void admin(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        request.setAttribute("admin", modeleAdmin.getAdmin());
        request.setAttribute("home", modeleAdmin.listerAllNews());
        redirection("admin.jsp", request, response);
    }

    private void supprimerCommentaire(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        modeleAdmin.supprimerCommentaire(Integer.parseInt(request.getParameter("idCommentaire")));
        redirection("index.jsp",request,response); 
    }

    private void affichierNews(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        UserModele um=new UserModele();
        News oldNews=um.detailsNews(Integer.parseInt(request.getParameter("IdNews")));
        request.setAttribute("news", oldNews);
        redirection("modifier.jsp", request, response);
    }

    private void modifier(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        AdminModele modele=new AdminModele();
        News neufNews=new News();
        String id = request.getParameter("idNews");
        neufNews.setIdNews(Integer.parseInt(id));
        neufNews.setTitre(String2Utf8.converterString(request.getParameter("title")));
        neufNews.setTags(request.getParameter("tags"));
        neufNews.setContenu(String2Utf8.converterString(request.getParameter("contient")));
        neufNews.setDate(new Date(System.currentTimeMillis()));
        modele.modifierNews(Integer.parseInt(id),neufNews);
        redirection("index.jsp",request,response);
    }

}
