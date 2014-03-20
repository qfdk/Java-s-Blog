/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entites.Commentaire;
import entites.News;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author qfdk
 */
public class UserModele {

    private EntityManagerFactory factory;
    protected EntityManager manager;
    private String nomCookie = "qfdkprojet";

    public UserModele() {
        factory = Persistence.createEntityManagerFactory("BlogPU");
        manager = factory.createEntityManager();
    }

    public void saveSessionUtilisateur(HttpServletRequest request, String nom) {
        HttpSession session = request.getSession(true);
        session.setAttribute("client", nom);
    }

    public String getSessionUtilisateur(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return (String) session.getAttribute("client");
    }

    public List<News> listerAllNews(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> arrList = manager.createNamedQuery("News.findAll")
                .setMaxResults(config.Config.NB_NEWS_MAX)
                .setFirstResult(config.Config.NB_NEWS_MAX * (id - 1)).getResultList();
        tx.commit();
        return arrList;
    }

    public List<News> listerAllNews() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> arrList = manager.createNamedQuery("News.findAll")
                .getResultList();
        tx.commit();
        return arrList;
    }

    public List<News> listerParTags(String tags) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> arrList = manager.createNamedQuery("News.findByTags")
                .setParameter("tags", tags).getResultList();
        tx.commit();
        return arrList;
    }

    public List<News> listerParTags(String tags, Integer id) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> arrList = manager.createNamedQuery("News.findByTags")
                .setParameter("tags", tags)
                .setMaxResults(config.Config.NB_NEWS_MAX)
                .setFirstResult(config.Config.NB_NEWS_MAX * (id - 1)).getResultList();
        tx.commit();
        return arrList;
    }

    public News detailsNews(Integer idNewsInteger) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        News news = (News) manager.createNamedQuery("News.findByIdNews")
                .setParameter("idNews", idNewsInteger).getSingleResult();
        tx.commit();
        return news;
    }

    public List<Commentaire> listerCommentairesByIdNews(Integer idNews) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Commentaire> commentaires = manager.createNamedQuery("Commentaire.findByIdNews")
                .setParameter("idNews", idNews)
                .getResultList();
        tx.commit();
        return commentaires;
    }

    public Integer nombreDeCommentaires() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Commentaire> commentaires = manager.createNamedQuery("Commentaire.findAll")
                .getResultList();
        tx.commit();
        return commentaires.size();
    }

    public void ajouterCommentaire(Commentaire commentaire) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        //System.out.print("coucou");
        manager.persist(commentaire);
        tx.commit();
    }

    public List<News> rechererNews(String mot) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> newses = manager.createNamedQuery("News.findByKey")
                .setParameter("key", "%" + mot + "%").getResultList();
        tx.commit();
        return newses;
    }

    /**
     * ******
     * @param request
     * @return 
     * @throws java.lang.Exception
     */
    public Integer afficherNombreMessagesUtilisateur(HttpServletRequest request)
            throws NullPointerException, Exception {
        Cookie cookieBlog = getCookie(request, nomCookie);
        String valeurCookie;
        if (cookieBlog != null) {
            valeurCookie = cookieBlog.getValue();
        } else {
            valeurCookie = "0";
        }
        return Integer.parseInt(valeurCookie);
    }

    private static Cookie getCookie(HttpServletRequest request, String nom) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null && nom.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public void incrementerCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookieBlog = getCookie(request, nomCookie);
        if (cookieBlog == null) {
            // Création du cookie.
            cookieBlog = new Cookie(nomCookie, "1");
            cookieBlog.setMaxAge(60 * 60 * 24 * 365);
        } else {
            String valeurCookie = cookieBlog.getValue();
            int valeurCookieEntier;
            try {
                valeurCookieEntier = Integer.parseInt(valeurCookie);
            } catch (NumberFormatException e) {
                valeurCookieEntier = 1;
            }
            valeurCookieEntier++;
            cookieBlog.setValue(String.valueOf(valeurCookieEntier));
        }
        response.addCookie(cookieBlog);
    }

}
