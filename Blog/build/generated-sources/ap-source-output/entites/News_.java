package entites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-19T01:03:38")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> idNews;
    public static volatile SingularAttribute<News, String> tags;
    public static volatile SingularAttribute<News, String> contenu;
    public static volatile SingularAttribute<News, Integer> score;
    public static volatile SingularAttribute<News, Date> date;
    public static volatile SingularAttribute<News, String> titre;

}