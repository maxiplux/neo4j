package blog.juanfrancisco.migrafo.repositories;

import blog.juanfrancisco.migrafo.models.Job;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
@Repository
public interface JobRepository extends Neo4jRepository<Job, Long> {

    Optional<Job> findByName(String name);

    @Query("MATCH p=(parent:Job {name: {name} } )-[r:in*]->(child:Job ) RETURN child ")
    Collection<Job> getProgenies(@Param("name") String name);

    @Query("MATCH p=(parent:Job )-[r:in*]->(child:Job {name: {name}}) RETURN p")
    Collection<Job> getAccents(@Param("name") String name);

}