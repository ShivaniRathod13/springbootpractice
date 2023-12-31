package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "WelCome to courese application DCBDU";
	}
	
	//get all courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//get course by courseId
//	@GetMapping("courses/{courseId}")
//	public Optional<Course> getCourse(@PathVariable String courseId) {
//		return this.courseService.getCourse(Long.parseLong(courseId));
//	}

	@GetMapping("courses/{courseId}")
	public Course getCourse(@PathVariable Long courseId ){
		return this.courseService.getCourse(courseId);

	}



//	Delete course by courseId
//	@DeleteMapping("/courses/{courseId}")
//	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
//		try {
//			this.courseService.deleteCourse(Long.parseLong(courseId));
//			return new ResponseEntity<>(HttpStatus.OK);
//			}catch (Exception e) {
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//	}


	//DELETE
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<String>deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>("DeleteSucessful",HttpStatus.OK);


		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}



//	@DeleteMapping("/course/{courseId}")
//	private void deleteCourse(@PathVariable String courseId)   
//	{  
//		this.courseService.deleteCourse(Long.parseLong(courseId));  
//	}  
	
	//Add Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}

}

