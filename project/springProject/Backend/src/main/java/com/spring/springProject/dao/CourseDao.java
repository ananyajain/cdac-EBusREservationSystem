package com.spring.springProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springProject.entities.Course;

public interface CourseDao extends JpaRepository<Course,Long>{


}
