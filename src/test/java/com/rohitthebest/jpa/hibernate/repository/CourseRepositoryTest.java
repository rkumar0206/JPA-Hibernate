package com.rohitthebest.jpa.hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.rohitthebest.jpa.hibernate.demo.JpaHibernateApplication;
import com.rohitthebest.jpa.hibernate.demo.entity.Course;
import com.rohitthebest.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootTest(classes = JpaHibernateApplication.class)
class CourseRepositoryTest {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Test
	void findById_basics() {

		Course course = repository.findById(10002L);
		assertEquals("Spring in 50 steps", course.getName());
	}

	@Test
	@DirtiesContext // after the test is run it will reset the data
	void deleteById_basics() {

		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext // after the test is run it will reset the data i.e. rolls back the database
	void save_basics() {

		// get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 steps", course.getName());

		// update details
		course.setName("JPA in 50 steps - updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 steps - updated", course1.getName());

	}

}
