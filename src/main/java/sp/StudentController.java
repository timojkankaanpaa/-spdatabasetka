package sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentRepository repository;
	//http://localhost:8080/student
    @RequestMapping(value = "/student" , method = RequestMethod.POST)
    public @ResponseBody Student addStudent(@RequestBody Student jsonStudent) {
    	return repository.save(jsonStudent);
    }  
    
    @RequestMapping(value = "/student" , method = RequestMethod.DELETE)
    public void deleteStudent(@RequestBody Student jsonStudent) {
    	repository.delete(jsonStudent);
        //do business logic
    }      
    
    @RequestMapping(value = "/student" , method = RequestMethod.PUT)
    public @ResponseBody Student updateStudent(@RequestBody Student jsonStudent) {
    	return repository.save(jsonStudent);
    } 
    
    
    @RequestMapping(value = "/student", method = RequestMethod.GET, produces={"application/json","application/xml"})
    public Student get(@RequestParam(value="id", defaultValue="1") int id){
    	return repository.findOne(id);
    }    
    
    @RequestMapping(value ="/test", method = RequestMethod.GET)
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return "{\"id\":\"hello\"}";
    } 
}
