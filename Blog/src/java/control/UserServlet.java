 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entites.Commentaire;
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
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String actionString = null;
        try {
            actionString = request.getParameter("action");

            switch (actionString) {
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
                case "details":
                    detailsParIdNews(request, response);
                    redirection("details.jsp", request, response);
                    break;
                case "ajouterCommentaire":
                    ajouterCommentaireParIdNews(request, response);
                    break;
                case "rechercher":
                    rechercher(request,response);
                    redirection("resultat.jsp", request, response);
                    break;
                default:
                    redirection("index.jsp", request, response);
            }
        } catch (Exception e) {
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
        //response.setCharacterEncoding("UTF-8");
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
        //response.setCharacterEncoding("UTF-8");
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

    private void detailsParIdNews(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        Integer idNews = 0;
        try {
            idNews = Integer.parseInt(request.getParameter("IdNews"));
        } catch (Exception e) {
            redirection("index.jsp", request, response);
        }
        request.setAttribute("details", um.detailsNews(idNews));
        request.setAttribute("commentaires", um.listerCommentairesByIdNews(idNews));
    }

    private void ajouterCommentaireParIdNews(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserModele um = new UserModele();
        Commentaire commentaire = new Commentaire();
        Integer idNews = 0;
        String nomString = null;
        String contenuString = null;
        nomString = request.getParameter("nom");
        contenuString = request.getParameter("contenu");
        idNews = Integer.parseInt(request.getParameter("IdNews"));
        commentaire.setNom(nomString);
        commentaire.setContenu(contenuString);
        commentaire.setIdNews(idNews);
        commentaire.setDateCommentaire(new Date(System.currentTimeMillis()));
        um.ajouterCommentaire(commentaire);
        response.getWriter().print("ok");
        //request.setAttribute("commentaires", um.listerCommentairesByIdNews(idNews));
    }

    protected void redirection(String lien, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(lien).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void rechercher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserModele um = new UserModele();
        request.setAttribute("key", um.recherNews(String2Utf8.converterString(request.getParameter("motcle"))));
    }

}
