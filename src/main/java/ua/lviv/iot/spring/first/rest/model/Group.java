package ua.lviv.iot.spring.first.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "\"group\"")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Integer id;
  @Column
  private String name;
  @Column
  private Integer enrollmentYear;

  @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnoreProperties("group")
  private Set<Student> students;

  public Group() {
  }

  public Set<Student> getStudents() {
    return students;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getEnrollmentYear() {
    return enrollmentYear;
  }

  public void setEnrollmentYear(Integer enrollmentYear) {
    this.enrollmentYear = enrollmentYear;
  }
}
