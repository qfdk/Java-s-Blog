/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entites.Admin;
import entites.Commentaire;
import entites.News;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author qfdk
 */
public class AdminModele extends UserModele {

    private Admin admin = null;
    private HttpSession session;

    public AdminModele() {
        super();
    }

    public boolean connextion(String login, String mdp, HttpServletRequest request) {
        if (!manager.createNamedQuery("Admin.login")
                .setParameter("login", login).setParameter("mdp", mdp)
                .getResultList().isEmpty()) {
            try {
                admin = (Admin) manager.createNamedQuery("Admin.login")
                        .setParameter("login", login).setParameter("mdp", mdp)
                        .getSingleResult();
                creerSession(request);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void creerSession(HttpServletRequest request) {
        session = request.getSession(true);
        session.setAttribute("admin", getAdmin());
        session.setAttribute("estAdmin", true);
    }

    public void seDeconnecter(HttpServletRequest request)
            throws SQLException, Exception {
        session = request.getSession();
        session.invalidate();
    }

    public void ajouterNews(News news) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(news);
        tx.commit();
    }

    public void supprimerNews(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(manager.createNamedQuery("News.findByIdNews").setParameter("idNews", id).getSingleResult());
        tx.commit();
    }

    public void supprimerAllCommentaire(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        List<Commentaire> commentaires = manager.createNamedQuery("Commentaire.findByIdNews").setParameter("idNews", id).getResultList();
        tx.begin();
        for (Commentaire c : commentaires) {
            manager.remove(c);
        }
        tx.commit();
    }

    public void supprimerCommentaire(Integer id) {
        EntityTransaction tx = manager.getTransaction();
        Commentaire commentaire = (Commentaire) manager.createNamedQuery("Commentaire.findByIdCommentaire")
                .setParameter("idCommentaire", id).getSingleResult();
        tx.begin();
        manager.remove(commentaire);
        tx.commit();
    }

    public void modifierNews(Integer idInteger,News news) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(news);
        tx.commit();
    }

}
