package com.attendanceUtilitySystem.utility.services.sessions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.attendanceUtilitySystem.utility.dao.profiles.StudentProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.sessions.ClassInfoDao;
import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;

@Service
public class ClassInfoServiceImp implements ClassInfoService {

	@Autowired
	private ClassInfoDao classDao;

	@Autowired
	private StudentProfileDao studentDao;
	
	@Override
	public void insertClassInfo(ClassModel classinfo) {
		List<StudentProfile> students = classinfo.getStudent();
		classinfo.setStudent(Collections.emptyList());
		classDao.save(classinfo);

		students.forEach((student)->{
			student.setClassinfo(classinfo);
			studentDao.save(student);
		});
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
		if(classDao.findById(classid).isPresent()){
			classDao.deleteById(classid);
		}
	}

}
