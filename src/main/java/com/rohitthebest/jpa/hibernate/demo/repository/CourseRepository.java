package com.rohitthebest.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rohitthebest.jpa.hibernate.demo.entity.Course;

@Repository
//if it is not then we cannot manipulate the data in the database, 
//ex : insert, delete, etc
@Transactional
public class CourseRepository {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Course findById(Long id) {

		return em.find(Course.class, id);
	}

	// insert or update
	public Course save(Course course) {

		if (course.getId() == null) {

			// insert

			em.persist(course);

		} else {

			// update

			em.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {

		Course course = findById(id);

		em.remove(course);
	}

	public void playWithEntityManager() {

		Course course = new Course("Web services in 100 steps");
		em.persist(course);

		// here we don't need to em.merge as Transactional annotation keeps track of
		// what is happening in the transaction and whenever something changes
		// it updates it in database
		course.setName("Web services in 100 steps - Updated");
	}

}
