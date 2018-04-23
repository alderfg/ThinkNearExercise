package com.thinknear.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_class")
public class Class implements Serializable {
	
	@Id
	private String code;
	private String title;
	private String description;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "tb_detail_student_class",
			joinColumns = { @JoinColumn(name = "code") }, 
			inverseJoinColumns = { @JoinColumn(name = "studentid") }
			)
	@JsonIgnore
    private List<Student> students;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}*/
	
	
}
