package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.CourseRepository;
import kodlama.io.devs.entities.concretes.Course;

@Repository
public class InMemoryCourseRepository implements CourseRepository {

	List<Course> courses;

	public InMemoryCourseRepository() {
		courses = new ArrayList<Course>();
		courses.add(new Course(1, "Java"));
		courses.add(new Course(2, "C#"));
		courses.add(new Course(3, ".NET"));
		courses.add(new Course(4, "Python"));
	}

	@Override
	public void add(Course course) {
		courses.add(course);
	}

	@Override
	public void delete(int id) {
		for (Course course1 : courses) {
			if (course1.getId()==id) {
				courses.remove(id);
			}
		}
	}

	@Override
	public void update(Course course, int id) {
		for (Course course2 : courses) {
			if (course2.getId() == id) {
				course2.setName(course.getName());
			}
		}
	}

	@Override
	public Course getById(int id) {
		for (Course course : courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		return null;
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return courses;
	}

}
