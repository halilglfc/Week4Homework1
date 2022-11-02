package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.CourseService;
import kodlama.io.devs.dataAccess.abstracts.CourseRepository;
import kodlama.io.devs.entities.concretes.Course;

@Service
public class CourseManager implements CourseService{
	private CourseRepository courseRepository;
	

	@Autowired
	public CourseManager(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	boolean isCourseNameEmpty(String course) {
		if(course == null || course.isEmpty()) {
			return true;
		}else
			return false;
	}
	
	boolean isCourseNameExist(String course) {
		for (Course course1 : courseRepository.getAll()) {
			if(course1.getName()==course) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Course> getAll() {
		return courseRepository.getAll();
	}


	@Override
	public void add(Course course) throws Exception {
		if(isCourseNameEmpty(course.getName())==true) {
			throw new Exception("Programlama dili boş bırakılamaz."); 
		}
		else if(isCourseNameExist(course.getName())==true) {
			throw new Exception("Aynı isimli programlama dili mevcut.");
		}
		else
		{courseRepository.add(course);}
	}


	@Override
	public void delete(int id) {
		courseRepository.delete(id);
	}


	@Override
	public void update(Course course, int id) {
		courseRepository.update(course, id);
	}


	@Override
	public Course getById(int id) {
		return courseRepository.getById(id);
		
	}

}
