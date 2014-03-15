/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import entites.Admin;
import entites.News;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author qfdk
 */
public class AdminModele extends UserModele{

    private Admin admin=null;
    
    public AdminModele()
    {
        super();
    }
    
    public boolean connextion(String login,String mdp)
    {
        if(!manager.createNamedQuery("Admin.login").setParameter("login",login).setParameter("mdp", mdp).getResultList().isEmpty())
        {
            try{
                admin=(Admin) manager.createNamedQuery("Admin.login").setParameter("login",login).setParameter("mdp", mdp).getSingleResult();
            }catch(Exception e)
            {
            }
            return true;
        }
        return false;
    }
    
    public Admin getAdmin()
    {
        return admin;
    }
    
    public void ajouterAdmin() {
//         factory = Persistence.createEntityManagerFactory("BlogPU");
//         manager = factory.createEntityManager();
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
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(news);
        tx.commit();
    }

    public void supprimerNews(int id) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.remove(manager.createNamedQuery("News.findByIdNews").setParameter("idNews", id).getSingleResult());
        tx.commit();
    }

    public void modifierNews(int id,News news) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        News oldNews=(News)manager.createNamedQuery("News.findByIdNews").setParameter("idNews", id).getSingleResult();
        supprimerNews(id);
        oldNews=news;
        ajouterNews(oldNews);
        tx.commit();
    }
    
}
