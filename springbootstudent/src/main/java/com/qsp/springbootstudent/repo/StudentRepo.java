package com.qsp.springbootstudent.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springbootstudent.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	Student findStudentByEmail(String email);

	Student getByPhone(long phone);
	List<Student>  findStudentByPercentageGreaterThan(double percentage);
	List<Student>  findStudentByPercentageLessThan(double percentage);
	
	@Query("SELECT e FROM Student e WHERE e.percentage<=?1")
	List<Student>  findStudentByPercentageLessThanEqual(double percentage);
	
	
	
	

}
