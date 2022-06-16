package com.elearning.web.Service;

import com.elearning.web.Controller.NotFoundException;
import com.elearning.web.Domain.Teacher;
import com.elearning.web.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teachRepo;

    public List<Teacher> listAll(){
        return (List<Teacher>) teachRepo.findAll();
    }

    public void save(Teacher teacher) {
        teachRepo.save(teacher);
    }

    public Teacher get(Integer teacherId) throws NotFoundException {
        Optional<Teacher> result = teachRepo.findById(teacherId);
        if(result.isPresent()){
            return result.get();
        }
        throw new NotFoundException("could not find any Teacher with ID " + teacherId);
    }

    public void deleteId(Integer teacherId) throws NotFoundException {
        teachRepo.deleteById(teacherId);
    }



    public Teacher addTeacher(Teacher teacher){
        return teachRepo.save(teacher);
    }

}
