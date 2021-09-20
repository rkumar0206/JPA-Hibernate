package com.rohitthebest.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rohitthebest.jpa.hibernate.demo.JpaHibernateApplication;
import com.rohitthebest.jpa.hibernate.demo.entity.Course;
import com.rohitthebest.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootTest(classes = JpaHibernateApplication.class)
class CourseRepositoryTest {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Test
	void contextLoads() {

		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());
	}

}
