package com.attendanceUtilitySystem.utility.models.profiles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity(name = "StudentProfile")
@Table(name = "StudentProfileTable")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile extends UserProfile {

	@Autowired
	@ManyToOne
	@JsonIgnoreProperties("student")
	@JoinColumn(name = "class_id", nullable = false)
	private ClassModel classinfo;

}
