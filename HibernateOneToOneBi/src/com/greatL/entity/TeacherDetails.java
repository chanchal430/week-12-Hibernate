package com.greatL.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_details")
public class TeacherDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "hobby")
	private String hobby;
	
	
	@OneToOne(mappedBy = "teacherDetails", cascade = CascadeType.ALL)
	private Teacher teacher;

	public TeacherDetails() {
		
	}

	public TeacherDetails( String city, String hobby) {
		super();
		
		this.city = city;
		this.hobby = hobby;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "TeacherDetails [id=" + id + ", city=" + city + ", hobby=" + hobby +" ]";
	}
	
	
}
