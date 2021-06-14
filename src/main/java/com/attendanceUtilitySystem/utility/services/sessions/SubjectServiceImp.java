package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.Collections;
import java.util.List;

import com.attendanceUtilitySystem.utility.dao.profiles.ProfessorProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.sessions.SubjectInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@Service
public class SubjectServiceImp implements SubjectService {

	@Autowired
	SubjectInfoDao subjectDao;

	@Autowired
	ProfessorProfileDao professorDao;
	
	@Override
	public boolean insertSubject(SubjectModel subject) {
		List<ProfessorProfile> professors = subject.getProfessor();
		subject.setProfessor(Collections.emptyList());
		subjectDao.save(subject);

		for(ProfessorProfile prof: professors){
			prof.setSubject(subject);
			professorDao.save(prof);
		}
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
		if(subjectDao.findById(subject_Id).isPresent()){
			subjectDao.deleteById(subject_Id);
		}
		return true;
	}

}
