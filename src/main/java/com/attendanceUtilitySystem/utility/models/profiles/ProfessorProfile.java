package com.attendanceUtilitySystem.utility.models.profiles;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@Component
@Entity(name = "ProfessorProfile")
@Table(name = "ProfessorProfileTable")
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class ProfessorProfile extends UserProfile {

	@Autowired
	@JoinColumn(name = "subject_id", nullable = false)
	@ManyToOne
	private SubjectModel subject;
	
//	@Autowired
//	@OneToMany(targetEntity = LectureModel.class, cascade = CascadeType.ALL, mappedBy = "professor")
//	private List<LectureModel> lecture;
//
}
