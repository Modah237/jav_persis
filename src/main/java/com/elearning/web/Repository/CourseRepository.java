package com.elearning.web.Repository;

import com.elearning.web.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository  extends JpaRepository<Course, Integer> {
}
