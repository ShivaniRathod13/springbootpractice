package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Optional<Course> getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public void deleteCourse(long parseLong);

	public Course updateCourse(Course course);
}
