package com.thinknear.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thinknear.model.Student;
import com.thinknear.repository.StudentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Student" })
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/students")
	@ApiOperation(value = "Browse list of all Student", response = Student.class)
	public List<?> listAll() {

		List<?> lstStudent = studentRepository.findAll();

		return lstStudent;
	}

	@GetMapping("/classes/{classCode}/students")
	@ApiOperation(value = "View all Students assigned to a Class", response = Student.class)
	public List<?> listAllByClass(@PathVariable(value = "classCode") String classCode) {

		List<?> lista = studentRepository.findByClasses_Code(classCode);

		return lista;
	}

	@GetMapping("/students/search")
	@ApiOperation(value = "Search Student by available fields/associations", response = Student.class)
	public List<?> listAllByFields(@RequestParam(value = "classCode", required = false) String classCode,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "firstName", required = false) String firstName) {

		List<?> lstStudent = studentRepository.findByLastNameOrFirstNameOrClasses_Code(lastName, firstName, classCode);

		return lstStudent;
	}

	@PostMapping("/students")
	@ApiOperation(value = "Create Student", response = Student.class)
	public Student create(@RequestBody Student student) {

		Student studentCreated = studentRepository.save(student);

		return studentCreated;
	}

	@DeleteMapping("/students/{id}")
	@ApiOperation(value = "Delete Student", response = String.class)
	public String delete(@PathVariable(value = "id") int studentId) {

		studentRepository.deleteById(studentId);

		return "Success";
	}

	@PutMapping("/students")
	@ApiOperation(value = "Update Student", response = Student.class)
	public Student update(@RequestBody Student student) {

		Student studentUpdated = studentRepository.save(student);

		return studentUpdated;
	}

}
