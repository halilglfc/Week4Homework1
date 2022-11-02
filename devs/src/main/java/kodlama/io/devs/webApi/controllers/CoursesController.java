package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.CourseService;
import kodlama.io.devs.entities.concretes.Course;

@RestController 
@RequestMapping("/api/courses")
public class CoursesController {
	private CourseService courseService;

	@Autowired
	public CoursesController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/getall")
	public List<Course> getAll(){
		return courseService.getAll();
	}
	@PostMapping("/add")
	public void add(Course course) throws Exception {
		courseService.add(course);
	}
	@DeleteMapping("/delete")
	public void delete(int id) {
		courseService.delete(id);
	}
	@PostMapping("/update")
	public void update(Course course,int id) {
		courseService.update(course, id);
	}
	@GetMapping("/getbyid")
	public Course getById(int id) {
		return courseService.getById(id);
	}
}
