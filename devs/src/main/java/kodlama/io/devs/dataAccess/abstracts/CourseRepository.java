package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Course;

public interface CourseRepository {
	
	public void add(Course course);
	public void delete(int id);
	public void update(Course course, int id);
	public Course getById(int id);
	List<Course> getAll();
}
