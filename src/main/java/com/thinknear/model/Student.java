package com.thinknear.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_student")
public class Student implements Serializable{

	@Id
	@Column(name = "studentid")
	private int studentId;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "firstname")
	private String firstName;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "tb_detail_student_class",
			joinColumns = { @JoinColumn(name = "studentid") }, 
			inverseJoinColumns = { @JoinColumn(name = "code") }
			)
	@JsonIgnore
	private List<Class> classes;
	
	public Student() {}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
}
