package com.elearning.web.Repository;

import com.elearning.web.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends JpaRepository<Student,Integer> {

}
