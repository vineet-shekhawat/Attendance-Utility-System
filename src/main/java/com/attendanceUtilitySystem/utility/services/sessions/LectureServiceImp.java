package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.sessions.LectureInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;

@Service
public class LectureServiceImp implements LectureService{

	@Autowired
	LectureInfoDao lectureDao;
	
	@Override
	public void insertLecture(LectureModel lecture) {
		lectureDao.save(lecture);
	}

	@Override
	public void updateLecture(LectureModel lecture) {
		lectureDao.save(lecture);
	}

	@Override
	public List<LectureModel> getLectures() {
		return lectureDao.findAll();
	}

}
