package ru.home;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import ru.home.config.ApplicationConfig;
import ru.home.model.Counterparty;
import ru.home.model.Country;
@ComponentScan("ru.home.config")
public class Starter {

    @Autowired
    private static MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        mongoTemplate= (MongoTemplate) context.getBean("mongoTemplate");
        System.out.println("Connected.");
        mongoTemplate.dropCollection(Counterparty.class);
        mongoTemplate.dropCollection(Country.class);
        Country usa=new Country("USA","Unated States of America");
        mongoTemplate.insert(usa);
        Counterparty ford = new Counterparty("Ford", "Ford motor company", usa);
        mongoTemplate.insert(ford);
        List<Counterparty> cptys =  (List<Counterparty>) mongoTemplate.query(ford.getClass()).all();
        System.out.println(cptys);
        System.exit(0);
    }
}
