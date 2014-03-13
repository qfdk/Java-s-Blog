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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author qfdk
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findByIdNews", query = "SELECT n FROM News n WHERE n.idNews = :idNews"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByTags", query = "SELECT n FROM News n WHERE n.tags = :tags"),
    @NamedQuery(name = "News.findByScore", query = "SELECT n FROM News n WHERE n.score = :score"),
    @NamedQuery(name = "News.findByDate", query = "SELECT n FROM News n WHERE n.date = :date")})
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNews")
    private Integer idNews;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 50)
    @Column(name = "tags")
    private String tags;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "contient")
    private String contient;
    @Column(name = "score")
    private Integer score;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public News() {
    }

    public News(Integer idNews) {
        this.idNews = idNews;
    }

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContient() {
        return contient;
    }

    public void setContient(String contient) {
        this.contient = contient;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNews != null ? idNews.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.idNews == null && other.idNews != null) || (this.idNews != null && !this.idNews.equals(other.idNews))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.News[ idNews=" + idNews + " ]";
    }
    
}
