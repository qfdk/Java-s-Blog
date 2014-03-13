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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.AdminModele;
import modele.UserModele;

/**
 *
 * @author qfdk
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        PrintWriter out = response.getWriter();
        String actionString = request.getParameter("action");
        switch (actionString) {
            case "login":
                login(request, response);
                break;
            case "editer":
                //加载到admin里面
                News neufNews = new News();
                neufNews.setTitle(request.getParameter("title"));
                neufNews.setTags(request.getParameter("tags"));
                neufNews.setContient(request.getParameter("contient"));
                neufNews.setDate(new Date(System.currentTimeMillis()));

                redirection(Config.PAGE_INDEX, request, response);
                break;
            case "listerNews":
                listerNews(request, response);
                redirection("news.jsp", request, response);
                break;
            case "listerJava":
                listerJava(request, response);
                redirection("java.jsp", request, response);
                break;
            case "home":
                listerAll(request, response);
                redirection("home.jsp", request, response);
                break;
            default:
                redirection("index.jsp", request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void login(HttpServletRequest request, HttpServletResponse response) {
        AdminModele modeleAdmin = new AdminModele();
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        if (mdp == null || login == null) {
            redirection(Config.PAGE_INDEX, request, response);
        } else if (modeleAdmin.connextion(login, mdp)) {
                redirection("admin.jsp", request, response);
            } else {
            redirection(Config.PAGE_INDEX, request, response);
        }
    }

    private void listerNews(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        request.setAttribute("news", um.listerParTags("News"));
    }

    private void listerJava(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        request.setAttribute("java", um.listerParTags("Java"));
    }

    private void listerAll(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        request.setAttribute("home", um.listerAllNews());
    }

    private void redirection(String lien, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(lien).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
