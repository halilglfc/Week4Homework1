package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Course;

public interface CourseService {
	List<Course> getAll();
	public void add(Course course) throws Exception;
	public void delete(int id);
	public void update(Course course, int id);
	public Course getById(int id);
}
