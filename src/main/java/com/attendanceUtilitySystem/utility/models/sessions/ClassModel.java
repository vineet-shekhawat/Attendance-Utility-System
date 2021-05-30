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
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Class_ID", updatable = false, nullable = false)
	private Long class_id;
	
	@Column(name = "Yearofjoining", updatable = false, nullable = false)
	private String year;
	@Column(name = "Branchname", updatable = false, nullable = false)
	private String branch;
	@Column(name = "Section_no", updatable = false, nullable = false)
	private String section;
	
	@Autowired
	@OneToMany(targetEntity = StudentProfile.class, cascade = CascadeType.ALL, mappedBy = "classinfo")
	private List<StudentProfile> students;
	
	@Autowired
	@OneToMany(targetEntity = LectureModel.class, cascade = CascadeType.ALL, mappedBy = "classinfo")
	private List<LectureModel> lectures;
	
}
