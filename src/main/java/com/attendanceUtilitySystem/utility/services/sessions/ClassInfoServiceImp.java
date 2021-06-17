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

import javax.transaction.Transactional;

@Service
public class ClassInfoServiceImp implements ClassInfoService {

	@Autowired
	private ClassInfoDao classDao;

	@Autowired
	private StudentProfileDao studentDao;

	@Override
	public ClassModel getClassBasicInfoByID(String classid) {
		if(classDao.findById(classid).isPresent()) {
			return classDao.getOne(classid);
		} else{
			return null;
		}
	}

	@Override
	public List<ClassModel> getAllClasses() {
		return classDao.findAll();
	}

	@Override
	public ClassModel ClassInfoWithStudentsByID(String classid) {
		if(classDao.findById(classid).isPresent()) {
			return classDao.getOne(classid);
		} else{
			return null;
		}
	}

	@Override
	@Transactional
	public String insertClassInfo(ClassModel classinfo) {
		if(classDao.findById(classinfo.getClassid()).isPresent()) {
			return "Class already exists";
		} else{
			List<StudentProfile> students = classinfo.getStudent();

			ClassModel newclassinfo = new ClassModel();
			newclassinfo.setClassid(classinfo.getClassid());
			newclassinfo.setBranch(classinfo.getBranch());
			newclassinfo.setSection(classinfo.getSection());
			newclassinfo.setYear(classinfo.getYear());
			//classinfo.setStudent(Collections.emptyList());
			classDao.save(newclassinfo);

			students.forEach((student) -> {
				student.setClassinfo(classinfo);
				studentDao.save(student);
			});

			return "Class inserted successfully";
		}
	}

	@Override
	@Transactional
	public String deleteClassInfo(String classid) {
		if(classDao.findById(classid).isPresent()) {
			classDao.deleteById(classid);
			return "class info deleted successfully";
		} else {
			return "class doesn't exists";
		}
	}
}
