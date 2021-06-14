package com.attendanceUtilitySystem.utility.models.sessions;

import java.util.List;

import javax.persistence.*;

import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity(name = "SubjectInfo")
@Table(name = "SubjectInfoTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectModel {
	@Id
	@Column(name = "Subject_ID", nullable = false, updatable = false)
	private String subject_id;

	@Column(name = "Subjectname")
	private String subjectname;
	
	@Column(name = "Description")
	private String description;

	@Autowired
	@OneToMany(targetEntity = ProfessorProfile.class, cascade = CascadeType.ALL, mappedBy = "subject")
	private List<ProfessorProfile> professor;

}
