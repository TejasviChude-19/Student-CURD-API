package com.qsp.springbootstudent.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.repo.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo repo;
	public Student saveStudent(Student student) {
		System.out.println(student);
		return repo.save(student);
		
	}
	public Student findStudent(int id) {
		//return repo.findById(id).get();
		Optional<Student> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	public List<Student> findAllStudent() {
		return repo.findAll();
	}
	public Student deleteStudent(int id) {
		 Optional<Student> optional=repo.findById(id);
			if(optional.isPresent()) {
				repo.deleteById(id);
				return optional.get();
			}
			return null;
	}
	
	 public Student updateStudent(int id,Student student) {
		  Optional<Student> optional=repo.findById(id);
		   if(optional.isEmpty()) {
			   student.setId(id);
			   return repo.save(student);
		   }
		   return null;
	       }
	 
//	 public Student findStudentByEmail(String email) {
//			return repo.findStudentByEmail(email);
//	}
	
	public List<Student> findStudentByPercentageGreaterThanEqual(double percentage) {
		 return findStudentByPercentageGreaterThanEqual(percentage);
	}
	public List<Student> findStudentByPercentageLessThanEqual(double percentage) {
		 return findStudentByPercentageLessThanEqual(percentage);
	}

		
	}


	

	 


