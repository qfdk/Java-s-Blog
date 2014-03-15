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

/**
 *
 * @author qfdk
 */
public class UserModele {

    private EntityManagerFactory factory;
    protected EntityManager manager;

    public UserModele() {
        factory = Persistence.createEntityManagerFactory("BlogPU");
        manager = factory.createEntityManager();
    }

    public List<News> listerAllNews() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> arrList = manager.createNamedQuery("News.findAll").getResultList();
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

    public void ajouterCommentaire(Commentaire commentaire) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(commentaire);
        tx.commit();
    }
}
