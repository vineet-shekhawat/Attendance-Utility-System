package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.SubjectInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@Service
public class SubjectServiceImp implements SubjectService {

	@Autowired
	SubjectInfoDao subjectDao;
	
	@Override
	public boolean insertSubject(SubjectModel subject) {
		subjectDao.save(subject);
		return true;
	}

	@Override
	public List<SubjectModel> getSubjectsAll() {
		return subjectDao.findAll();
	}

	@Override
	public SubjectModel getSubjectID(String subject_Id) {
		return subjectDao.getSubjectbySubjectID(subject_Id);
	}

	@Override
	public boolean deleteSubject(String subject_Id) {
		//TODO : IMPLEMENTATION
		subjectDao.deleteSubjectbySubjectID(subject_Id);
		return true;
	}

}
