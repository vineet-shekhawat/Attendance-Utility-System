package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@Service
public interface SubjectService {
	public boolean insertSubject(SubjectModel subject);
	public List<SubjectModel> getSubjectsAll();
	public SubjectModel getSubjectID(String subject_Id);
	public boolean deleteSubject(String subject_Id);
}
