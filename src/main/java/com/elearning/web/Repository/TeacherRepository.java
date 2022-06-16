package com.elearning.web.Repository;

import com.elearning.web.Domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
