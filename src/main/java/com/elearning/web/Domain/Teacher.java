package com.elearning.web.Domain;

import javax.persistence.*;
import javax.security.auth.Subject;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(nullable = false,length = 25)
    private String teacherName;
    @Column(nullable = false, unique = true,length = 45)
    private String teacherEmail;
    @Column(nullable = false,length = 25)
    private String teacherAddress;
    private int age;
    private boolean enabled;


    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherName, String teacherEmail, String teacherAddress, int age, boolean enabled) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherAddress = teacherAddress;
        this.age = age;
        this.enabled = enabled;
    }

    public Course getSubjects() {
        return subjects;
    }

    public void setSubjects(Course subjects) {
        this.subjects = subjects;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course subjects;




}
