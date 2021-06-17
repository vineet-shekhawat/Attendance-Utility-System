package com.attendanceUtilitySystem.utility.services.sessions;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.attendanceUtilitySystem.utility.models.attendance.TimePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.sessions.LectureInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;

import javax.transaction.Transactional;

@Service
public class LectureServiceImp implements LectureService{

	@Autowired
	private LectureInfoDao lectureDao;

	private Boolean checkLecturePossible(LectureModel newLecture){
		Boolean possible = true;
		List<LectureModel> lectures = lectureDao.findByClassidAndDate(newLecture.getClassinfo().getClassid(),
				newLecture.getDateOfLecture());

		for(LectureModel lecture: lectures){
			if( lecture.getLectureCancelled()==false &&
					(newLecture.getStartTime().isBefore(lecture.getEndTime()) &&
					newLecture.getStartTime().isAfter(lecture.getStartTime())) ||
					(newLecture.getEndTime().isBefore(lecture.getEndTime()) &&
							newLecture.getEndTime().isAfter(lecture.getStartTime())) ||
					newLecture.getStartTime().equals(lecture.getStartTime()) ||
					newLecture.getEndTime().equals(lecture.getEndTime())){
				possible = false;
				break;
			}
		}
		return possible;
	}

	@Override
	@Transactional
	public String insertLectureForTomorrow(LectureModel lecture) {
		if(lectureDao.findById(lecture.getLecture_id()).isPresent()){
			return "lecture already exists";
		} else{
			if(checkLecturePossible(lecture)) {
				lectureDao.save(lecture);
				return "lecture setup successfully";
			}
			return "lecture is scheduled at your interval";
		}
	}

	@Override
	@Transactional
	public String updateLectureTime(LectureModel lecture) {
		if(lectureDao.findById(lecture.getLecture_id()).isPresent()){
			if(checkLecturePossible(lecture)){
				lectureDao.save(lecture);
				return "lecture info updated";
			}
			return "lecture is scheduled at your interval";
		} else{
			return "lecture doesn't exixts";
		}
	}

	@Override
	public List<LectureModel> getLecturesForStudents(String classid) {
		List<LectureModel> lectures = lectureDao.findByClassidAndDate(classid, LocalDate.now());
		return lectures;
	}

	@Override
	public List<LectureModel> getLecturesForProfessor(String profid, Integer period) {
		return lectureDao.findByProfidAndAfterThatDate(profid, LocalDate.now().minusDays(period));
	}

	@Override
	@Transactional
	public String cancelLecture(String lectureid) {
		LectureModel lecture =  lectureDao.findById(lectureid).orElse(null);
		if(lecture==null) return "lecture doesn't exists";
		lecture.setLectureCancelled(true);
		return "lecture cancelled successfully;";
	}
}
