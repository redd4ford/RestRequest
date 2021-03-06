package ua.lviv.iot.spring.first.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.business.StudentService;
import ua.lviv.iot.spring.first.rest.model.Student;

@RequestMapping("/students")
@RestController
public class StudentsController {
  private Map<Integer, Student> students = new HashMap<>();
  @Autowired
  private StudentService studentService;

  @GetMapping
  public List<Student> getStudents(final @RequestParam(name = "firstName", required = false)
                                   String firstName) {
    if (firstName == null) {
      return studentService.findAll();
    }
    return studentService.getAllByFirstName(firstName);
  }

  @GetMapping(path = "/{id}")
  public Student getStudent(@PathVariable("id") Integer studentId) {
    System.out.println(studentId);
    return students.get(studentId);
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public Student createStudent(final @RequestBody Student student) {
    return studentService.createStudent(student);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer studentId) {
    HttpStatus status = students.remove(studentId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Student> updateStudent(final @PathVariable("id") Integer studentId,
                                               final @RequestBody Student student) {
    student.setId(studentId);
    HttpStatus status;
    if (students.containsKey(studentId)) {
      students.put(studentId, student);
      status = HttpStatus.OK;
      return ResponseEntity.status(status).build();
    } else {
      status = HttpStatus.NOT_FOUND;
      return ResponseEntity.status(status).build();
    }

  }

}