package com.spring.springProject.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springProject.dao.CourseDao;
import com.spring.springProject.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	//List<Course>courses;
	
	public CourseServiceImpl() {
		/*
		 * courses = new ArrayList<Course>();
		 * 
		 * courses.add(new Course(151,"Java","Start with the basics of java"));
		 * courses.add(new
		 * Course(3415,"SpringBoot","Create restapi with the spring boot"));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Optional<Course> getCourse(Long courseId) {
		
		/*
		 * for(Course course : courses) { if(course.getId() == courseId) return course;
		 * }
		 */
		return courseDao.findById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		/*
		 * if(course == null) return null;
		 * 
		 * courses.add(course);
		 */
		System.out.println(course);
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		
		/*
		 * courses.forEach(e -> { if(e.getId() == course.getId()) {
		 * e.setName(course.getName()); e.setDescription(course.getDescription()); } });
		 */
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(Long courseId) {
		//courses = this.courses.stream().filter(e->e.getId() !=courseId).collect(Collectors.toList());
		Course course = courseDao.getOne(courseId);
		courseDao.delete(course);
	}

}
