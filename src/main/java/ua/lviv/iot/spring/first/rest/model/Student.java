package ua.lviv.iot.spring.first.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.*;

@Entity
@NamedNativeQuery(name = "Student.findBestStudent", query = "select * from student where id = 1")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column
  private String firstName;
  @Column
  private String lastName;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "group_id")
  @JsonIgnoreProperties("students")
  private Group group;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "students_subjects",
             joinColumns = {@JoinColumn(name = "student_id", nullable = false)},
                           inverseJoinColumns = {@JoinColumn(name = "subject_id", nullable = true)})
  @JsonIgnoreProperties("students")
  private Set<Subject> subjects;

  public Student() {
  }

  public Student(String firstName, String lastName) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(Set<Subject> subjects) {
    this.subjects = subjects;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}