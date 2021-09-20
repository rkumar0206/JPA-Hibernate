package com.rohitthebest.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rohitthebest.jpa.hibernate.demo.entity.Course;

@Repository
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		
		return em.find(Course.class, id);
	}
	
//	// insert or update
//	public Course save(Course course) {
//		
//		
//	}
//	
//	public Course deleteById(Long id) {
//		
//	}
//	
}
