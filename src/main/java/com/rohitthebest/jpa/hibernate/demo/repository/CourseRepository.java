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

		Course course1 = new Course("Web services in 100 steps");
		em.persist(course1);
		Course course2 = new Course("Angular js in 100 steps");
		em.persist(course2);
		
		// this method just sent out the changes until now out of the database, we
		// can call this method many times
		em.flush();
		
		// here we don't need to em.merge() as enitity manager keeps track of
		// what is happening in the transaction and whenever something changes
		// it updates it in database
		course1.setName("Web services in 100 steps - Updated");
		
		
		// using this method the course2 is no longer tracked by the entity manager
		//em.detach(course2);

		// this method clear whatever there is in entity manager
		//em.clear();
		
		// this will not be executed as the we have called the detach method above
		course2.setName("Angular js in 100 steps - Updated");
		
		// the contents of the course 1 is refreshed and we get the course 1 value
		// which is inserted in the database. calling this method will not update the contents
		// of the course1
		em.refresh(course1);
		
		
		em.flush();
		
	}

}
