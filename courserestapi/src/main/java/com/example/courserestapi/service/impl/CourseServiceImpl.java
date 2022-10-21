package com.example.courserestapi.service.impl;

import com.example.courserestapi.Exception.CustomNotFound;
import com.example.courserestapi.Exception.ErrorCodeEnum;
import com.example.courserestapi.dto.CourseDto;
import com.example.courserestapi.model.Course;
import com.example.courserestapi.repository.CourseRepository;
import com.example.courserestapi.response.CourseResponse;
import com.example.courserestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse getAllCourses() {
 List<CourseDto> courseDtoList=courseRepository.findAll().
         stream().
         map(course -> convertToDto(course)).
         collect(Collectors.toList());
return CourseResponse.builder().courseDtos(courseDtoList).build();
    }

    @Override
    public CourseDto getById(long id) {
     return  courseRepository.findById(id).map(course ->convertToDto(course)).orElseThrow(()->new CustomNotFound(ErrorCodeEnum.COURSE_NOT_FOUND));
    }

    @Override
    public CourseResponse getByNameAndLessons(String name, String lessons) {
       List<CourseDto> courseDtoList= courseRepository.getCoursesByNameAndLessons(name,lessons).stream().map(course -> convertToDto(course)).collect(Collectors.toList());
   return makeCourseResponse(courseDtoList);
    }

    @Override
    public void insert(CourseDto courseDto) {
Course course=new Course();
BeanUtils.copyProperties(courseDto,course);
courseRepository.save(course);
    }

    @Override
    public void update(CourseDto courseDto, long id) {
        Course course=courseRepository.findById(id).orElseThrow(()->new CustomNotFound(ErrorCodeEnum.COURSE_NOT_FOUND)) ;
course.setId(courseDto.getId());
course.setName(courseDto.getName());
course.setTitle(courseDto.getTitle());
course.setLessons(courseDto.getLessons());
courseRepository.save(course);
    }

    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);
    }


    private CourseDto convertToDto(Course course) {
        CourseDto courseDto=new CourseDto();
        BeanUtils.copyProperties(course,courseDto);
        return courseDto;

    }

private CourseResponse makeCourseResponse(List<CourseDto> courseDtoList){
        return CourseResponse.builder().courseDtos(courseDtoList).build();
}
}
