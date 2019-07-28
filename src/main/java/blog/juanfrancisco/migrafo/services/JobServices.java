package blog.juanfrancisco.migrafo.services;

import blog.juanfrancisco.migrafo.models.Job;
import blog.juanfrancisco.migrafo.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobServices {

    @Autowired
    private JobRepository jobRepository;

    public void deleteAll() {
        this.jobRepository.deleteAll();
    }

    public Job save(Job job) {
        return this.jobRepository.save(job);
    }

    public List<Job> findAll() {
        return (List<Job>) this.jobRepository.findAll();
    }

    public void initAll() {
        this.jobRepository.deleteAll();
        Job CMXSXT1=  new Job();
        Job CMXSXT2=  new Job();
        Job CMXSXT3=  new Job();
        Job CMXSXT4=  new Job();
        CMXSXT1.setName("1");
        CMXSXT2.setName("2");
        CMXSXT3.setName("3");
        CMXSXT4.setName("4");


        CMXSXT2.addInPuts(CMXSXT1);
        CMXSXT3.addInPuts(CMXSXT2);
        CMXSXT4.addInPuts(CMXSXT3);

        this.jobRepository.save(CMXSXT1);
        this.jobRepository.save(CMXSXT2);
        this.jobRepository.save(CMXSXT3);
        this.jobRepository.save(CMXSXT4);
    }
    public Map<String,Map< String, List<Job>> > getGenealogy(String jobName)
    {
        Map<String , Map< String, List<Job> >> genealogy = new HashMap<>();
        this.jobRepository.findByName(jobName).ifPresent( jobDb -> {



            Map< String, List<Job> > families = new HashMap<>();
            families.put("accents", (List<Job>) this.jobRepository.getAccents(jobName));
            families.put("progenies", (List<Job>) this.jobRepository.getProgenies(jobName));
            genealogy.put("family",families);

        });
        return genealogy;

    }
}
