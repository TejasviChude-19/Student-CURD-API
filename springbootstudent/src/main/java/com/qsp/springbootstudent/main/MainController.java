package com.qsp.springbootstudent.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.springbootstudent.dao.StudentDao;
import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.responsestructure.ResponseStructure;
import com.qsp.springbootstudent.service.StudentService;

@RestController
public class MainController {
	@Autowired
	private StudentDao dao;
	@Autowired
	private StudentService service;
	@PostMapping("/save")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
		
	}
	 @GetMapping("/fetch")
	 public ResponseEntity<ResponseStructure<Student>> findStudent(@RequestParam int id) {
		return service.findStudent(id);
	}
	 @GetMapping("/fetchAll")
	 public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
	 return  service.findAllStudent();
	}
	
	 @DeleteMapping("/delete/{id}")
		public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id) {
			return service.deleteStudent(id);
		}
	 
	 @PutMapping("/update")
		public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id, @RequestBody Student student) {
			return service.updateStudent(id, student);
		}
//	 @GetMapping("/updateByEmail")
//		public ResponseStructure<Student>updateByEmail(@RequestParam String email) {
//			return service.findByEmail(email);
//		}

		@PatchMapping("/updateStudentEmail/{email}")
		public ResponseEntity<ResponseStructure<Student>> updateStudentEmail(@PathVariable String email,@RequestParam int id) {
			return service.updateStudentEmail(id,email);
		}
		@PatchMapping("/updateStudentPercentage")
		public ResponseEntity<ResponseStructure<Student>> updateStudentPercentage(@RequestParam int id,@RequestParam int percentage) {
			return service.updateStudentPercentage(id,percentage);
		}
	}
		


