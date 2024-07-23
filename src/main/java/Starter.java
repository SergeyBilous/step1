import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.home.config.ApplicationConfig;
@ComponentScan("ru.home.config")
public class Starter {

    @Autowired
    private static MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        mongoTemplate= (MongoTemplate) context.getBean("mongoTemplate");
        System.exit(0);
    }
}
