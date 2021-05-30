package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.ClassInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;

@Service
public class ClassInfoServiceImp implements ClassInfoService {

	@Autowired
	private ClassInfoDao classDao;
	
	@Override
	public void insertClassInfo(ClassModel classinfo) {
		classDao.save(classinfo);
	}

	@Override
	public List<ClassModel> getAllClasses() {
		return classDao.findAll();
	}

	@Override
	public ClassModel getClassInfoByID(String classid) {
		return classDao.getClassbyClassID(classid);
	}

	@Override
	public void deleteClassInfo(String classid) {
		// TODO Auto-generated method stub
		
	}

}
