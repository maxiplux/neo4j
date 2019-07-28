package blog.juanfrancisco.migrafo.controllers;

import blog.juanfrancisco.migrafo.models.Job;
import blog.juanfrancisco.migrafo.repositories.JobRepository;
import blog.juanfrancisco.migrafo.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class JobController {




    @Autowired
    private JobServices jobServices;







    @GetMapping("/start")
    //http://localhost:8080/start
    public List<Job> start(){
        this.jobServices.initAll();
        return  this.jobServices.findAll();
    }


    @GetMapping("/families")
   /* http://localhost:8080/families?jobName=1
    http://localhost:8080/families?jobName=2
    http://localhost:8080/families?jobName=3
    http://localhost:8080/families?jobName=4

    */
    public Map<String,Map< String, List<Job>> > graph(@RequestParam(value = "jobName",required = true) String jobName) {

        return  this.jobServices.getGenealogy(jobName);
    }



}
