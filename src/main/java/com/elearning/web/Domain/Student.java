package com.elearning.web.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name ="student")
public class Student{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer studentId;


    @Column(nullable = false,length = 25)
    private String studentName;

    private  int studentAge;

    @Column(nullable = false, unique = true,length = 45)
    private String studentEmail;

    @Column(nullable = false,length = 25)
    private String studentAddress;

    private boolean enabled;

    public Student(){

    }

    public Student(Integer studentId, String studentName, int studentAge, String studentEmail, String studentAddress, boolean enabled) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
        this.enabled = enabled;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Course> getSubjects() {
        return courses;
    }

    public void setSubjects(Set<Course> subjects) {
        this.courses = subjects;
    }

    @ManyToMany
    @JoinTable(
            name = "Student_course_table",
            joinColumns = @JoinColumn(name = "Student_ID"),
            inverseJoinColumns = @JoinColumn(name = "Course_ID")
    )
    private Set<Course>  courses = new HashSet<>();


}
