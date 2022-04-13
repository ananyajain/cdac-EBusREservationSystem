package com.spring.springProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springProject.entities.Course;
import com.spring.springProject.service.CourseService;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/")
	public List<Course> getCourses(){
		System.out.println("anshul");
		return this.courseService.getCourses();
	}
	
	@GetMapping("/{courseId}")
	public Optional<Course> getCourse(@PathVariable String courseId){
		
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course){
		
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/update")
	public Course updateCourse(@RequestBody Course course){
		
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/delete/{courseId}")
	public void deleteCourse(@PathVariable String courseId){
		
		this.courseService.deleteCourse(Long.parseLong(courseId));
	}
}
