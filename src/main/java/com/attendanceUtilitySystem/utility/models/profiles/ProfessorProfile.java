package com.attendanceUtilitySystem.utility.models.profiles;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity(name = "ProfessorProfile")
@Table(name = "ProfessorProfileTable")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorProfile extends UserProfile {

	@Autowired
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
	private SubjectModel subject;
	
	@Autowired
	@OneToMany(targetEntity = LectureModel.class, cascade = CascadeType.ALL, mappedBy = "professorObj")
	private List<LectureModel> lectures;
		
}
