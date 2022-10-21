package com.example.courserestapi.service;

import com.example.courserestapi.dto.CourseDto;
import com.example.courserestapi.repository.CourseRepository;
import com.example.courserestapi.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
CourseResponse getAllCourses();
CourseDto getById(long id);
CourseResponse getByNameAndLessons(String name,String lessons);

    void insert(CourseDto courseDto);
    void update(CourseDto courseDto,long id);

    void delete(long id);
}
