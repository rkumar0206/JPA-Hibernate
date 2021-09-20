package com.rohitthebest.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rohitthebest.jpa.hibernate.demo.entity.Course;

@Repository
//if it is not then we cannot manipulate the data in the database, 
//ex : insert, delete, etc
@Transactional
public class CourseRepository {

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

}
