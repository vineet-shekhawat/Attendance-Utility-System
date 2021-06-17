package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;

@Service
public interface ClassInfoService {
	public ClassModel getClassBasicInfoByID(String classid);
	public ClassModel ClassInfoWithStudentsByID(String classid);
	//public ClassModel ClassInfoWithLecturesByID(String classid);

	//ADMIN APIs
	public List<ClassModel> getAllClasses();
	public String insertClassInfo(ClassModel classinfo);
	public String deleteClassInfo(String classid);
}