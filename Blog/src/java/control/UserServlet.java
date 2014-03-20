 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entites.Commentaire;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
        nbCommentaire(request, response);
        afficherNombreMessagesUtilisateur(request, response);
        String actionString = "";
        try {
            actionString = request.getParameter("action");

            switch (actionString) {
                case "listerNews":
                    listerNews(request, response);
                    redirection(config.Config.PAGE_NEWS, request, response);
                    break;
                case "listerJava":
                    listerJava(request, response);
                    redirection(config.Config.PAGE_JAVA, request, response);
                    break;
                case "home":
                    listerAll(request, response);
                    redirection(config.Config.PAGE_HOME, request, response);
                    break;
                case "details":
                    detailsParIdNews(request, response);
                    redirection(config.Config.PAGE_DEDAIlS, request, response);
                    break;
                case "ajouterCommentaire":
                    ajouterCommentaireParIdNews(request, response);
                    break;
                case "rechercher":
                    rechercher(request, response);
                    redirection(config.Config.PAGE_RESULTAT, request, response);
                    break;
                default:
                    redirection(config.Config.PAGE_INDEX, request, response);
            }
        } catch (Exception e) {
            redirection(config.Config.PAGE_INDEX, request, response);
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
        doPost(request, response);
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
        //doGet(request, response);
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    //lister News

    private void listerNews(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        Integer numpageInteger = Integer.parseInt(request.getParameter("NumPage"));
        request.setAttribute("all", um.listerParTags("News"));
        request.setAttribute("news", um.listerParTags("News", numpageInteger));
    }

    private void listerJava(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        Integer numpageInteger = Integer.parseInt(request.getParameter("NumPage"));
        request.setAttribute("all", um.listerParTags("Java"));
        request.setAttribute("java", um.listerParTags("Java", numpageInteger));
    }

    private void listerAll(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        Integer numpageInteger = Integer.parseInt(request.getParameter("NumPage"));
        request.setAttribute("all", um.listerAllNews());
        request.setAttribute("home", um.listerAllNews(numpageInteger));
    }

    private void detailsParIdNews(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        try {
            Integer idNews = Integer.parseInt(request.getParameter("IdNews"));
            um.getSessionUtilisateur(request);
            request.setAttribute("details", um.detailsNews(idNews));
            request.setAttribute("commentaires", um.listerCommentairesByIdNews(idNews));
        } catch (NumberFormatException e) {
            redirection(config.Config.PAGE_ERROR, request, response);
        }

    }

    private void ajouterCommentaireParIdNews(HttpServletRequest request, HttpServletResponse response) {
        try {      
            UserModele um = new UserModele();
            Commentaire commentaire = new Commentaire();
            Integer idNews = Integer.parseInt(request.getParameter("IdNews"));
            String nomString = request.getParameter("nom");
            String contenuString = request.getParameter("contenu");
            
            commentaire.setNom(nomString);
            commentaire.setContenu(contenuString);
            commentaire.setIdNews(idNews);
            commentaire.setDateCommentaire(new Date(System.currentTimeMillis()));
            um.incrementerCookie(request, response);
            um.ajouterCommentaire(commentaire);
            um.saveSessionUtilisateur(request, nomString);
            response.getWriter().print("ok");
            //request.setAttribute("commentaires", um.listerCommentairesByIdNews(idNews));
        } catch (IOException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    protected void redirection(String lien, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(lien).forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void rechercher(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserModele um = new UserModele();
            request.setAttribute("key", um.rechererNews(String2Utf8.converterString(request.getParameter("motcle"))));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void nbCommentaire(HttpServletRequest request, HttpServletResponse response) {
        UserModele um = new UserModele();
        request.setAttribute("nbcommentaires", um.nombreDeCommentaires());
    }

    protected void afficherNombreMessagesUtilisateur(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserModele um = new UserModele();
            request.setAttribute("nbclient", um.afficherNombreMessagesUtilisateur(request));
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
