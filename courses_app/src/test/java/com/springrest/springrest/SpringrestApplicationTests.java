package com.springrest.springrest;

import com.springrest.springrest.controller.MyController;
import com.springrest.springrest.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MyControllerTest {
	@Autowired
	private MyController myController;


	@Test
	void should_get_all_Course() {
		List<Course> courses = myController.getCourses();
		Course c1 = courses.get(0);
		assertEquals(c1.getId(), 101);
	}

	@Test
	public void should_add_course() {
		Course course = new Course();
		course.setId(120);
		course.setTitle("React");
		course.setDescription("basic course of react");
		assertEquals(course, this.myController.addCourse(course));
	}


	@Test
	public void should_update_course(){
		Course course = myController.getCourse(900L);
		course.setTitle("CORE JAVA");
		Course course1 = myController.updateCourse(course);
		assertEquals("CORE JAVA",course1.getTitle());



	}
	@Test
	void deleteCourse() {
		ResponseEntity<String> c2 = myController.deleteCourse("900");
		String s1 = c2.getBody();
	assertEquals( "DeleteSucessful",s1);

	}



}
