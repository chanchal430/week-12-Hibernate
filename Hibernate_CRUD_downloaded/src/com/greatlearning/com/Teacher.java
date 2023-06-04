package com.greatlearning.com;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="teacher")
public class Teacher {

     public Teacher() {	}

     

	public Teacher( String f_Name, String l_Name, String email) {
		this.f_Name = f_Name;
		this.l_Name = l_Name;
		this.email = email;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="f_Name")
	private String f_Name;
	
	@Column(name="l_Name")
	private String l_Name;
	
	@Column(name="email")
	private String email;
	
	//complex object
		@OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
		private TeacherDetails teacherDetails;
		
		@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
		private Set<Course> courses = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_Name() {
		return f_Name;
	}

	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}

	public String getL_Name() {
		return l_Name;
	}

	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Set<Course> getCourses() {
		return courses;
	}



	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}



	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}



	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}



	@Override
	public String toString() {
		return "Teacher [id=" + id + ", f_Name=" + f_Name + ", l_Name=" + l_Name + ", email=" + email + "]";
	}
	
	//scaffolding code to set both the sides of relationship
	//this code should be written int the parent entity class
	public void addTeacherDetails(TeacherDetails teacherDetails) {
		this.setTeacherDetails(teacherDetails);
		teacherDetails.setTeacher(this);
		
	}
		public void addCourse(Course course) {
			this.courses.add(course);
		//	course.setTeacher(this);
		}
	
	
}
