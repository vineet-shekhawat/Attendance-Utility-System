package com.attendanceUtilitySystem.utility.models.sessions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@JsonFormat(pattern = "hh:mm:ss")
	@Column(name = "StartTime")
	private LocalTime startTime;
	@JsonFormat(pattern = "hh:mm:ss a")
	@Column(name = "EndTime")
	private LocalTime endTime;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dateoflecture")
	private LocalDate dateOfLecture;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "lectureCancelled", nullable = false)
	private Boolean lectureCancelled;

	@Column(name = "startAttendance", nullable = false)
	private Boolean startAttendance;
}
