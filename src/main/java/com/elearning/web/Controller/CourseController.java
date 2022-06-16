package com.elearning.web.Controller;

import com.elearning.web.Domain.Course;
import com.elearning.web.Domain.Teacher;
import com.elearning.web.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CourseController {
    @Autowired private CourseService couservice;

    @GetMapping("/course")
    public String ShowCourseList(Model model){
        List<Course> listcourses= couservice.listAll();
        model.addAttribute("listcourses",listcourses);
        return "course";
    }

    @GetMapping("/course/new")
    public String showNewformCourse(Model model){
        model.addAttribute("course",new Course());
        model.addAttribute("pageTitle", "Add new User");
        return "add_course";
    }

    @PostMapping("/course/save")
    public String saveCourse(Course course, RedirectAttributes ra){
        couservice.save(course);
        ra.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/course";
    }
    @GetMapping("/course/edit/{courseId}")
    public String showEditFormTeacher(@PathVariable("courseId") Integer courseId, Model model, RedirectAttributes ra) {
        try {
            Course course = couservice.get(courseId);
            model.addAttribute("course", course);
            model.addAttribute("pageTitle", "Edit Course (ID: " + courseId +")");
            return "add_course";
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/course";
        }
    }

    @GetMapping("/course/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") Integer courseId, Model model, RedirectAttributes ra) {
        try {
            couservice.deleteId(courseId);
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/course";
    }

}
