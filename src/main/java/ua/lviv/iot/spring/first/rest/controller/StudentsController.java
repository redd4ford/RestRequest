package ua.lviv.iot.spring.first.rest.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring.first.rest.model.Student;

@RequestMapping("/students")
@RestController
public class StudentsController {

	@GetMapping(path = "/{id}")
	public Student getStudent(@PathVariable("id") Integer studentId) {
		System.out.println(studentId);
		return new Student("pedro", "aldomovar");
	}

//    @RequestMapping(method = { RequestMethod.GET, RequestMethod.PUT }, path = "/smartest")
//    public Student getSmartestStudent() {
//        return new Student("tapas", "karantino");
//    }
	@PostMapping
	//(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student);
		student.setId(2002);
		return student;
	}

}