package blog.juanfrancisco.migrafo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication

public class MigrafoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrafoApplication.class, args);
    }

}
