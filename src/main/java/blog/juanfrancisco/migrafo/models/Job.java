package blog.juanfrancisco.migrafo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.*;

@NodeEntity
@Data
@JsonIgnoreProperties(value = { "inPuts" })
public class Job   {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }


    @Relationship(type = "in", direction = Relationship.INCOMING)
    @JsonIgnore
    private Set<Job> inPuts  = new HashSet<>();




    public  void addInPuts(Job job)
    {



        inPuts.add(job);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return name.equals(job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}