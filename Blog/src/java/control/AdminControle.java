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
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.AdminModele;

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
        PrintWriter out = response.getWriter();
        try{
        String actionString = request.getParameter("action");
        switch (actionString) {
            case "login":
                login(request, response);
                break;
            case "ajouter":
                //加载到admin里面
                ajouterNews(request,response);
                redirection(Config.PAGE_INDEX, request, response);
                break;
            default:
                response.sendRedirect("index.jsp");
        }}catch(Exception e)
        {
            response.sendRedirect("index.jsp");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        if (mdp == null || login == null) {
            redirection(Config.PAGE_INDEX, request, response);
        } else if (modeleAdmin.connextion(login, mdp)) {
            request.setAttribute("admin", modeleAdmin.getAdmin());
            redirection(Config.PAGE_INDEX, request, response);
        } else {
            redirection(Config.PAGE_INDEX, request, response);
        }
    }

    private void ajouterNews(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        News neufNews = new News();
        neufNews.setTitre(request.getParameter("title"));
        neufNews.setTags(request.getParameter("tags"));
        neufNews.setContenu(request.getParameter("contient"));
        neufNews.setDate(new Date(System.currentTimeMillis()));
        modeleAdmin.ajouterNews(neufNews);
    }

}
