package com.example.courserestapi.response;

import com.example.courserestapi.dto.CourseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

private List<CourseDto> courseDtos;
}
