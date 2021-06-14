package com.attendanceUtilitySystem.utility.models.sessions;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity(name = "LectureInfo")
@Table(name = "LectureInfoTable")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LectureModel {

	@Id
	@Column(name = "LectureID", updatable = false, nullable = false)
	private String lecture_id;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "classid", nullable = false)
	private ClassModel classinfo;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name = "professorid", nullable = false)
	private ProfessorProfile professor;
	
	@Column(name = "StartTime")
	private LocalTime startTime;
	@Column(name = "EndTime")
	private LocalTime endTime;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "LectureCancel", nullable = false)
	private Boolean lectureCancelled = false;

}
