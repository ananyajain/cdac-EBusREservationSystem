package com.spring.springProject.service;

import java.util.List;
import java.util.Optional;

import com.spring.springProject.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Optional<Course> getCourse(Long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(Long courseId);
}
