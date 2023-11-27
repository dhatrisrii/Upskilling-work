package com.darden.dardenrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darden.dardenrestapi.model.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	//http://localhost:8080/student
	
	//private String sri;

	@GetMapping("/student")
	public ResponseEntity<Student> getStudent(){
		Student student = new Student(
				1,
				"Darden",
				"Project");
		return ResponseEntity.ok()
				.header("custom-header", "Darden")
				.body(student);
	}
	
	 // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Dhatri", "UI"));
        students.add(new Student(2, "Sushma", "MS"));
        students.add(new Student(3, "Maha", "UI"));
        students.add(new Student(4, "Rajitha", "MS"));
        return ResponseEntity.ok(students);
    }
    
 // http://localhost:8080/students/1/Dhatri/UI
    @GetMapping("{id}/{first-name}/{role}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("role") String role){
        Student student = new Student(studentId, firstName, role);
        return ResponseEntity.ok(student);
    }
	
 // Spring boot REST API with Request Param
    //  http://localhost:8080/students/query?id=1&firstName=Dhatri&role=UI
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String role){
        Student student = new Student(id, firstName, role);
        return ResponseEntity.ok(student);
    }
    
    // Spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    //http://localhost:8080/students/create
    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getRole());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    
 // Spring boot REST API that handles HTTP PUT Request - updating existing resource
  //http://localhost:8080/students/14/update
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getRole());
        return ResponseEntity.ok(student);
    }
    
 // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
  //http://localhost:8080/students/11/delete
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}
