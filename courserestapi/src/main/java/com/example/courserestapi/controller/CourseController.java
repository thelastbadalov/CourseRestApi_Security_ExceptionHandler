package com.example.courserestapi.controller;

import com.example.courserestapi.dto.CourseDto;
import com.example.courserestapi.response.CourseResponse;
import com.example.courserestapi.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Tag(name = "Course services")
public class CourseController {

private final CourseService courseService;


@GetMapping
    public CourseResponse getAllCourses(){
 return    courseService.getAllCourses();
}

@GetMapping("/{id}")
    public CourseDto getById(@PathVariable long id){
    return courseService.getById(id);
}

@GetMapping("/search")
    public CourseResponse getByNameAndLessons(@RequestParam String name,@RequestParam String lessons){
return courseService.getByNameAndLessons(name,lessons);
}
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid  @RequestBody CourseDto courseDto){
    courseService.insert(courseDto);
}
@PutMapping("/edit/{id}")
public void update(@RequestBody CourseDto courseDto,@PathVariable long id){
    courseService.update(courseDto,id);
}
@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
    courseService.delete(id);
}
}
