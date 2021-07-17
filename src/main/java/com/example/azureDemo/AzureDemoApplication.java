package com.example.azureDemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzureDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureDemoApplication.class, args);
	}
	
	@GetMapping("/getCourses")
	public String welcome() {
		StringBuilder courseDetails = new StringBuilder();
		List<Course> courses = DBConnection.getCourses();
		if(courses != null && !courses.isEmpty()) {
			courseDetails.append("CourseId---CouserName---Rating").append("\n");
			for(Course course : courses) {
				courseDetails.append(course.getCourseId()).append("---").append(course.getCourseName()).append("---").append(course.getRating()).append("\n");
			}
			
		}
		
	  return courseDetails.toString();	
			  
	}

}
