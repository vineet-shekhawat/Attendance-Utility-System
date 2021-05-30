package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;

@Service
public interface LectureService {
	public void insertLecture(LectureModel lecture);
	public void updateLecture(LectureModel lecture);
	public List<LectureModel> getLectures();
}
