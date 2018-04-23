package com.thinknear.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinknear.model.Class;

public interface ClassRepository extends JpaRepository<Class, String>{

	public List<?> findByStudents_StudentId(int studentId);
	public List<?> findDistinctClassByCodeOrTitleOrDescriptionOrStudents_StudentId(String code, String title, String description, Integer studentId);
	
}
