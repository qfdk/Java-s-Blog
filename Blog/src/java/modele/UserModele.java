/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entites.Admin;
import entites.News;
import java.util.ArrayList;
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
        List<News> arrList=manager.createNamedQuery("News.findAll").getResultList();
        tx.commit();
        return  arrList;
    }
    
    public List<News> listerParTags(String tags)
    {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<News> arrList=manager.createNamedQuery("News.findByTags")
                .setParameter("tags", tags).getResultList();
        tx.commit();
        return  arrList;
    }
}
