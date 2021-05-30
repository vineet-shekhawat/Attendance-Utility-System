package com.attendanceUtilitySystem.utility.models.sessions;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Data
@Builder
@AllArgsConstructor
public class SubjectModel {
	/*
	public long getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<ProfessorProfile> getProfessors() {
		return professors;
	}

	public void setProfessors(List<ProfessorProfile> professors) {
		this.professors = professors;
	}*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Subject_ID", nullable = false, updatable = false)
	private long subject_id;

	@Column(name = "Subjectname")
	private String subjectName;
	
	@Column(name = "Description")
	private String desc;
	
	@OneToMany(targetEntity = ProfessorProfile.class, cascade = CascadeType.ALL, mappedBy = "subject")
	private List<ProfessorProfile> professors;
	
}
