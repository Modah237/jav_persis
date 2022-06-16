package com.elearning.web.Service;

import com.elearning.web.Controller.NotFoundException;
import com.elearning.web.Domain.Student;
import com.elearning.web.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentrepo;

    public List<Student> listAll(){
        return (List <Student> )studentrepo.findAll();
    }

    public void save(Student student) {
        studentrepo.save(student);
    }

    public  Student get(Integer studentId) throws NotFoundException {
        Optional<Student> result = studentrepo.findById(studentId);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException("could not find any student with ID " + studentId);
    }

    public void deleteId(Integer id) throws NotFoundException {
        studentrepo.deleteById(id);
    }

}