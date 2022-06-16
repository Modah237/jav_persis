package com.elearning.web.Service;

import com.elearning.web.Controller.NotFoundException;
import com.elearning.web.Domain.Course;
import com.elearning.web.Domain.Teacher;
import com.elearning.web.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courserepo;

    public List<Course> listAll(){
        return (List<Course>) courserepo.findAll();
    }

    public void save(Course course) {
        courserepo.save(course);
    }

    public Course get(Integer courseId) throws NotFoundException {
        Optional<Course> result = courserepo.findById(courseId);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException("could not find any course with ID " + courseId);
    }

    public void deleteId(Integer id) throws NotFoundException {
        courserepo.deleteById(id);
    }
    public List<Course> getAllCourse(){
        return courserepo.findAll();
    }
}
