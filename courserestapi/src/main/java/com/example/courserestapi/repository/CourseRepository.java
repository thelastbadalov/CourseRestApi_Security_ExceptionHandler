package com.example.courserestapi.repository;

import com.example.courserestapi.model.Course;
import com.example.courserestapi.response.CourseResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> getCoursesByNameAndLessons(String name, String lessons);
}
