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
public class ModeleAdminTest {

    private EntityManagerFactory factory;
    private EntityManager manager ;
    public ModeleAdminTest()
    {
        factory = Persistence.createEntityManagerFactory("BlogPU");
         manager = factory.createEntityManager();
    }
    public boolean connextion(String login,String mdp)
    {
        //Query query= manager.createQuery("SELECT a FROM Admin a WHERE a.login='"+login+"'"+"AND a.mdp='"+mdp+"'");
        //Admin admin=(Admin)query.getSingleResult();
        //Admin admin=(Admin)manager.createNamedQuery("Admin.login").setParameter("login",login).setParameter("mdp", mdp).getResultList();
        if(!manager.createNamedQuery("Admin.login").setParameter("login",login).setParameter("mdp", mdp).getResultList().isEmpty())
        {
            return true;
        }
        return false;
    }
    public void ajouterAdmin() {
         factory = Persistence.createEntityManagerFactory("BlogPU");
         manager = factory.createEntityManager();
        Admin a = new Admin(2);
        a.setLogin("coucou");
        a.setMdp("0 0");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        //manager.persist(a);
        List<Object> ooo = manager.createNamedQuery("Admin.findAll").getResultList();
        for (Object aa : ooo) {
            System.out.append(aa.toString());
        }
        tx.commit();
    }

    public void deconnexion() {

    }

    public void ajouterNews(News news) {

    }

    public void supprimerNews(int id) {

    }

    public void modifierNews(int id) {

    }



    public ArrayList<News> listerFavoNewses() {
        return null;
    }
}
