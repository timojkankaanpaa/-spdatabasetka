package sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	@Autowired
	private ProjectRepository repository;
	//http://localhost:8080/project
    @RequestMapping(value = "/project" , method = RequestMethod.POST)
    public @ResponseBody Project addProject(@RequestBody Project jsonProject) {
    	return repository.save(jsonProject);
    }  
    
    @RequestMapping(value = "/project" , method = RequestMethod.DELETE)
    public void deleteProject(@RequestBody Project jsonProject) {
    	
    	repository.delete(jsonProject);
        //do business logic
    }      
    
    @RequestMapping(value = "/project" , method = RequestMethod.PUT)
    public @ResponseBody Project updateProject(@RequestBody Project jsonProject) {
    	return repository.save(jsonProject);
    } 
    
    
    @RequestMapping(value = "/project", method = RequestMethod.GET,produces={"application/json","application/xml"})
    public Project get(@RequestParam(value="id", defaultValue="1") int id){
    	return repository.findOne(id);
    }
}
