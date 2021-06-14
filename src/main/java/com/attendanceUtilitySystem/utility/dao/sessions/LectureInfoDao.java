package com.attendanceUtilitySystem.utility.dao.sessions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;

public interface LectureInfoDao extends JpaRepository<LectureModel,String>{

}
