package com.elearning.web.Controller;

import com.elearning.web.Domain.Course;
import com.elearning.web.Domain.Teacher;
import com.elearning.web.Service.CourseService;
import com.elearning.web.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.security.auth.Subject;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teachService;

    @GetMapping("/teacher")
    public String showTeacherList(Model model){
        List<Teacher> listTeachers = teachService.listAll();
        model.addAttribute("listTeachers",listTeachers);
        return "teacher";
    }

    @GetMapping("/teacher/new")
    public String showNewFormTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("course", courservi.getAllCourse());
        model.addAttribute("newCourse",new Course());
        model.addAttribute("pageTitle", "Add new Teacher");
        return "add_teacher";
    }

    @PostMapping("/teacher/save")
    public String saveTeacher(Teacher teacher, RedirectAttributes ra) {
        teachService.save(teacher);
        ra.addFlashAttribute("message", "The teacher has been saved successfully");
        return "redirect:/teacher";
    }

    @GetMapping("/teacher/edit/{teacherId}")
    public String showEditFormTeacher(@PathVariable("teacherId") Integer teacherId, Model model, RedirectAttributes ra) {
        try {
            Teacher teacher = teachService.get(teacherId);
            model.addAttribute("teacher", teacher);
            model.addAttribute("pageTitle", "Edit Teacher (ID: " + teacherId +")");
            return "add_teacher";
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/teacher";
        }
    }

    @GetMapping("/users/delete/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") Integer teacherId, Model model, RedirectAttributes ra) {
        try {
            teachService.deleteId(teacherId);
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/teacher";
    }


    @PostMapping("addTeacher")
    public String addVTypes(@ModelAttribute Teacher teacher, @ModelAttribute Course course, Model model){

        teacher.setSubjects(course);
        teachService.addTeacher(teacher);

        model.addAttribute("course", courservi.getAllCourse());
        model.addAttribute("newTeacher", new Teacher());
        model.addAttribute("newSubject", new Course());
        return "TeachersAdd";

    }

    @Autowired
    private CourseService courservi;


}
