package com.qsp.springbootstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.springbootstudent.dao.StudentDao;
import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.responsestructure.ResponseStructure;

@Service
public class StudentService  {
	@Autowired
	private StudentDao dao;
      
public ResponseStructure<Student> saveStudent(Student student){
		int securedmarks=student.getSecuredmarks();
		int total=student.getTotalmarks();
		int a = securedmarks*100;
		double percentage=(a)/total;
		student.setPercentage(percentage);
		if (percentage<35) {
			student.setGrade("fail");
		} else if (percentage>=35 && percentage<50) {
			student.setGrade("pass");
			
		}else if (percentage>=50 && percentage<65) {
			student.setGrade("second class");
		}else if (percentage>=65 && percentage<90) {
			student.setGrade("first class");
		}else if (percentage>=90) {
			student.setGrade("Distingtion");
		}
		 ResponseStructure<Student> structure=new ResponseStructure<Student>();
		structure.setMessage("saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student));
		return structure;
	}
public ResponseEntity<ResponseStructure<Student>> findStudent(int id){
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure=new ResponseStructure<Student>();
			
		if(student !=null) {
		structure.setMessage("find successful");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dao.saveStudent(student));
		 return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
	  }else {
		  structure.setMessage("Not Found");
		  structure.setStatus(HttpStatus.NOT_FOUND.value());
		  structure.setData(student);
		 return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
	}
	
   }
public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		List<Student> list= dao.findAllStudent();
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		if(list.isEmpty()) {
			structure.setMessage("Not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			 return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}else {
			structure.setMessage("found succeful");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
		}
		 return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		
	} 
public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id){
		 Student student = dao.findStudent(id);
			ResponseStructure<Student> structure=new ResponseStructure<Student>();
			if(student !=null) {
				structure.setMessage("delete Succefully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(student);
				return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
			}else {
				structure.setMessage("Not delete");
				structure.setStatus(HttpStatus.NO_CONTENT.value());
				structure.setData(student);
				return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NO_CONTENT);
			}
			
		}
		 //302
//  public ResponseEntity<ResponseStructure<Student>> findStudentByEmail(String email) {
//	Student student= dao.findStudentByEmail(email);
//	ResponseStructure<Student> structure=new ResponseStructure<Student>();
//			
//	if (student !=null) {
//		structure.setMessage("Data found successfully");
//		structure.setStatus(HttpStatus.FOUND.value());
//		structure.setData(student);
//		 return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
//		}else {
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("ID not present in database");
//			structure.setData(null);
//		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
//	}
//  }
public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) {
			Student student2 = dao.findStudent(id);
			ResponseStructure<Student> structure=new ResponseStructure<Student>();
			
			if (student!=null) {
				student.setId(id);
				saveStudent(student);
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMessage("Data Updated successfully");
				structure.setData(student);
				return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMessage("ID not present in database");
				structure.setData(null);
				return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
				
			}
		}

public ResponseEntity<ResponseStructure<Student>> updateStudentEmail(int id, String email) {
			ResponseStructure<Student> structure=new ResponseStructure<Student>();
			Student student = dao.findStudent(id);
			
			if (student!=null) {
				student.setEmail(email);
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setMessage("Data Updated successfully");
				structure.setData(dao.saveStudent(student));
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
			} else {
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setMessage("ID not present in database");
				structure.setData(null);
				
		    return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
			}
		}

public ResponseEntity<ResponseStructure<Student>> updateStudentPercentage(int id, int percentage) {
	ResponseStructure<Student> structure=new ResponseStructure<Student>();
	Student student = dao.findStudent(id);
			
	if (student!=null) {
		student.setId(id);
		student.setPercentage(percentage);
		saveStudent(student);
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Data Updated successfully");
		structure.setData(student);
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);	
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("ID not present in database");
			structure.setData(student);
		}
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
	}
	
public ResponseEntity<ResponseStructure<List<Student>>>findStudentByPercentageLessThanEqual(double percentage){
	List<Student> student= dao.findStudentByPercentageLessThanEqual(percentage);
	ResponseStructure<List<Student>> structure=new ResponseStructure<List<Student>>();
	if(student!=null){
		structure.setMessage("Data found");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(student);
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
     }else {
		     structure.setMessage("Data Not Found");
		 	 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 	 structure.setData(student);
		 	return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		  }		
    }


//public ResponseEntity<ResponseStructure<List<Student>>> updatePhone(int id,long phone) {
//    Student student=dao.findStudent(id);
//    student.setPhone(phone);
//    ResponseStructure<Student> structure=new ResponseStructure<Student>();
//    structure.setMessage("data updated");
//    structure.setStatus(HttpStatus.CREATED.value());
//    structure.setData(dao.updateAllStudent(id, student));
//    return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
//}
public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone) {
	  Student student=dao.findStudent(id);
	  student.setPhone(phone);
	  ResponseStructure<Student> structure=new ResponseStructure<Student>();
	  structure.setMessage("Data found");
	  structure.setStatus(HttpStatus.FOUND.value());
	  structure.setData(dao.updateStudent(id,student));
	  return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
	}

public ResponseEntity<ResponseStructure<Student>> updateName(int id, String name) {
	  Student student=dao.findStudent(id);
	  student.setName(name);
	  ResponseStructure<Student> structure=new ResponseStructure<Student>();
	  structure.setMessage("data updated");
	  structure.setStatus(HttpStatus.CREATED.value());
	  structure.setData(dao.updateStudent(id, student));
	  return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
}

public ResponseEntity<ResponseStructure<Student>> updateSecuredMarks(int id, int securedmarks) {
            Student student=dao.findStudent(id);	
            student.setSecuredmarks(securedmarks);
            ResponseStructure<Student> structure=new ResponseStructure<Student>();
            structure.setMessage("data updated");
            structure.setStatus(HttpStatus.CREATED.value());
            structure.setData(dao.updateStudent(id, student));
        return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);     

}

public ResponseEntity<ResponseStructure<List<Student>>> findStudentByPercentageGreaterThanEqual(double percentage){

     List<Student> student= dao.findStudentByPercentageGreaterThanEqual(percentage);
     ResponseStructure<List<Student>> structure=new ResponseStructure<List<Student>>();
 if(student!=null){
	structure.setMessage("Data found");
	structure.setStatus(HttpStatus.FOUND.value());
	structure.setData(student);
	return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
 }else {
	     structure.setMessage("Data Not Found");
	 	 structure.setStatus(HttpStatus.NOT_FOUND.value());
	 	 structure.setData(student);
	 	return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
	  }		
}


public  ResponseEntity<ResponseStructure<Student>> updateAge(int id, int age) {
	 Student student=dao.findStudent(id);
    student.setAge(age);
    ResponseStructure<Student> structure=new ResponseStructure<Student>();
    structure.setMessage("data updated");
    structure.setStatus(HttpStatus.CREATED.value());
    structure.setData(dao.updateStudent(id, student));
    return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
   }
}

		

		
	
		 
	 


	  
			         
