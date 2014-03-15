/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author qfdk
 */
@Entity
@Table(name = "commentaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM Commentaire c"),
    @NamedQuery(name = "Commentaire.findByIdCommentaire", query = "SELECT c FROM Commentaire c WHERE c.idCommentaire = :idCommentaire"),
    @NamedQuery(name = "Commentaire.findByNom", query = "SELECT c FROM Commentaire c WHERE c.nom = :nom"),
    @NamedQuery(name = "Commentaire.findByDateCommentaire", query = "SELECT c FROM Commentaire c WHERE c.dateCommentaire = :dateCommentaire"),
    @NamedQuery(name = "Commentaire.findByIdNews", query = "SELECT c FROM Commentaire c WHERE c.idNews = :idNews")})
public class Commentaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCommentaire")
    private Integer idCommentaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "contenu")
    private String contenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCommentaire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommentaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNews")
    private Integer idNews;

    public Commentaire() {
    }

    public Commentaire(Integer idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public Commentaire(Integer idCommentaire, String nom, String contenu, Date dateCommentaire, int idNews) {
        this.idCommentaire = idCommentaire;
        this.nom = nom;
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
        this.idNews = idNews;
    }

    public Integer getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Integer idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommentaire != null ? idCommentaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.idCommentaire == null && other.idCommentaire != null) || (this.idCommentaire != null && !this.idCommentaire.equals(other.idCommentaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Commentaire[ idCommentaire=" + idCommentaire + "+ ]"+nom;
    }
    
}
