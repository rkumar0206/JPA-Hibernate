package com.rohitthebest.jpa.hibernate.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rohitthebest.jpa.hibernate.demo.entity.Course;
import com.rohitthebest.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository repository;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course course = repository.findById(10001L);
		
		logger.info("Course : {}", course);
	}

}
