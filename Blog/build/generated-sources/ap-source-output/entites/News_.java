package entites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-13T22:47:32")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> idNews;
    public static volatile SingularAttribute<News, String> tags;
    public static volatile SingularAttribute<News, String> contient;
    public static volatile SingularAttribute<News, String> title;
    public static volatile SingularAttribute<News, Integer> score;
    public static volatile SingularAttribute<News, Date> date;

}