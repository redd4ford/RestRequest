package ua.lviv.iot.spring.first.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.dataaccess.StudentRepository;
import ua.lviv.iot.spring.first.rest.model.Student;

@Service
public class StudentService {
  @Autowired
  private StudentRepository studentRepository;

  public Student createStudent(Student student) {
    return studentRepository.save(student);

  }

  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  public List<Student> getAllByFirstName(String firstName) {
    return studentRepository.findAllByFirstName(firstName);
  }
}