package com.elearning.web.Controller;

import com.elearning.web.Domain.Student;
import com.elearning.web.Repository.StudentRepository;
import com.elearning.web.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @GetMapping("/student")
    public String ShowCourseList(Model model){
        List<Student> liststudents= studentservice.listAll();
        model.addAttribute("liststudents",liststudents);
        return "student";
    }

    @GetMapping("/student/new")
    public String showNewformCourse(Model model){
        model.addAttribute("student",new Student());
        model.addAttribute("pageTitle", "Add new Student");
        return "add_student";
    }

    @PostMapping("/student/save")
    public String saveCourse(Student student, RedirectAttributes ra){
        studentservice.save(student);
        ra.addFlashAttribute("message", "The Student has been saved successfully");
        return "redirect:/student";
    }
    @GetMapping("/student/edit/{studentId}")
    public String showEditFormCourse(@PathVariable("studentId") Integer studentId, Model model, RedirectAttributes ra) {
        try {
            Student student = studentservice.get(studentId);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Student (ID: " + studentId +")");
            return "add_student";
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/student";
        }
    }

    @GetMapping("/student/delete/{studentId}")
    public String deleteCourse(@PathVariable("studentId") Integer studentId, Model model, RedirectAttributes ra) {
        try {
            studentservice.deleteId(studentId);
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/student";
    }


    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/")
    public  String Home(Model model){
        return "index";
    }



}
