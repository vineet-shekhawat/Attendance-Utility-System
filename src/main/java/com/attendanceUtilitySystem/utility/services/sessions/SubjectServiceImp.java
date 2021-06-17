package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.Collections;
import java.util.List;

import com.attendanceUtilitySystem.utility.dao.profiles.ProfessorProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.sessions.SubjectInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

import javax.transaction.Transactional;

@Service
public class SubjectServiceImp implements SubjectService {

	@Autowired
	SubjectInfoDao subjectDao;

	@Autowired
	ProfessorProfileDao professorDao;
	
	@Override
	@Transactional
	public String insertSubject(SubjectModel subject) {
		if(subjectDao.findById(subject.getSubject_id()).isPresent()){
			return "subject already exists";
		} else {

			List<ProfessorProfile> professors = subject.getProfessor();
			subject.setProfessor(Collections.emptyList());
			subjectDao.save(subject);

			for (ProfessorProfile prof : professors) {
				prof.setSubject(subject);
				professorDao.save(prof);
			}
			return "subject is inserted with its professors";
		}
	}

	@Override
	public List<SubjectModel> getSubjectsAll() {
		return subjectDao.findAll();
	}

	@Override
	public SubjectModel getSubjectID(String subject_Id) {
		if(subjectDao.findById(subject_Id).isPresent()){
			return subjectDao.getSubjectbySubjectID(subject_Id);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public String deleteSubject(String subject_Id) {
		if(subjectDao.findById(subject_Id).isPresent()){
			subjectDao.deleteById(subject_Id);
			return "subject deleted successfully";
		} else{
			return "subject doesn't exists";
		}
	}

}
