package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@Service
public interface SubjectService {
	public SubjectModel getSubjectID(String subject_Id);
	//public SubjectModel subjectInfoWithProfessorsByID(String subjectid);

	//ADMIN APIs
	public List<SubjectModel> getSubjectsAll();
	public String insertSubject(SubjectModel subject);
	public String deleteSubject(String subject_Id);
}
