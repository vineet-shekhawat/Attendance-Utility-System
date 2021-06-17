package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import com.attendanceUtilitySystem.utility.models.attendance.TimePeriod;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;

@Service
public interface LectureService {
	public String insertLectureForTomorrow(LectureModel lecture);
	public String updateLectureTime(LectureModel lecture);
	public List<LectureModel> getLecturesForStudents(String classid);
	public List<LectureModel> getLecturesForProfessor(String profid, Integer period);
	public String cancelLecture(String lectureid);
}
