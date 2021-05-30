package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;

@Service
public interface ClassInfoService {
	
	public void insertClassInfo(ClassModel classinfo);
	public List<ClassModel> getAllClasses();
	public ClassModel getClassInfoByID(String classid);
	public void deleteClassInfo(String classid);

}
