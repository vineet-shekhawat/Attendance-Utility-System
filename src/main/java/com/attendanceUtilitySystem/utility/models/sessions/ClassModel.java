package com.attendanceUtilitySystem.utility.models.sessions;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.lang.String;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity(name = "ClassInfo")
@Table(name = "ClassInfoTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClassModel {
	@Id
	@Column(name = "Class_ID", updatable = false, nullable = false)
	private String classid;
	
	@Column(name = "year", updatable = false, nullable = false)
	private String year;
	@Column(name = "branch_name", updatable = false, nullable = false)
	private String branch;
	@Column(name = "section_name", updatable = false, nullable = false)
	private String section;
	
	@Autowired
	@JsonIgnoreProperties("classinfo")
	@OneToMany(targetEntity = StudentProfile.class, cascade = CascadeType.ALL, mappedBy = "classinfo")
	private List<StudentProfile> student;
	
	@Autowired
	@JsonIgnore()
	@OneToMany(targetEntity = LectureModel.class, cascade = CascadeType.ALL, mappedBy = "classinfo")
	private List<LectureModel> lecture;
}
