package com.thinknear.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thinknear.model.Class;
import com.thinknear.repository.ClassRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/class")
@Api(tags = {"Class"})
public class ClassController {
	
	@Autowired
	ClassRepository classRepository;

	@GetMapping
	@ApiOperation(value = "Browse list of all Classes", response = Class.class)
	public List<?> listAll() {
		
		List<?> lstClass = classRepository.findAll();
		
		return lstClass;
	}
	
	@GetMapping("/studentId={studentId}")
	@ApiOperation(value = "View all Classes assigned to a Student", response = Class.class)
	public List<?> listAllByStudent(@PathVariable(value = "studentId") int studentId ) {
		
		List<?> lstClass = classRepository.findByStudents_StudentId(studentId);
		
		return lstClass;
	}
	
	@GetMapping("/search")
	@ApiOperation(value = "Search Class by available fields/associations", response = Class.class)
	public List<?> listAllByFields(@RequestParam(value = "studentId", required = false) Integer studentId,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "description", required = false) String description) {

		List<?> lstClass = classRepository.findDistinctClassByCodeOrTitleOrDescriptionOrStudents_StudentId(code, title, description, studentId);

		return lstClass;
	}
	
	@PostMapping
	@ApiOperation(value = "Create Class", response = Class.class)
	public Class create(@RequestBody Class classRequest) {

		Class classCreated = classRepository.save(classRequest);

		return classCreated;
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Class", response = String.class)
	public String delete(@PathVariable(value = "code") String code) {
		
		classRepository.deleteById(code);
		
		return "Success";
	}

	@PutMapping
	@ApiOperation(value = "Update Class", response = Class.class)
	public Class update(@RequestBody Class classRequest) {

		Class classUpdated = classRepository.save(classRequest);

		return classUpdated;
	}

}
