package com.attendanceUtilitySystem.utility.controller;

import java.util.List;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.services.profiles.ProfessorProfileService;
import com.attendanceUtilitySystem.utility.services.profiles.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceUtilitySystem.utility.services.sessions.ClassInfoService;
import com.attendanceUtilitySystem.utility.services.sessions.LectureService;
import com.attendanceUtilitySystem.utility.services.sessions.SubjectService;
import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;
import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;
import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@RestController
public class UserProfileController {

	@Autowired
	private ProfessorProfileService profServ;

	@Autowired
	private StudentProfileService studentServ;
	
	@Autowired
	private ClassInfoService classServ;
	
	@Autowired
	private LectureService lectureServ;
	
	@Autowired
	private SubjectService subjectServ;
	
	@GetMapping("/home/profile/getProfile/professor")
	public List<ProfessorProfile>  getProfileInfo(@RequestParam(defaultValue = "empty") String user_id, @RequestParam(defaultValue = "empty") TypeOfUser type ){
		return this.profServ.fetchProfiles(user_id,type);
		
	}
	
	@PostMapping("/home/profile/updateProfile/professor/{usertype}")
	public void updateProfileForUser(@RequestBody ProfessorProfile profile, @PathVariable TypeOfUser usertype) {
		this.profServ.updateProfile(profile,usertype);
	}
	
	
	/*.............ADMIN APIs.........*/
	
	//For Profiles
	@PostMapping("/home/profile/insertProfile/professor/{usertype}")
	public void insertProfile(@RequestBody ProfessorProfile newprofile, @PathVariable TypeOfUser usertype) {
		this.profServ.addProfile(newprofile, usertype);
	}
	
	//TODO: For deleting profile
	
	//For Subjects
	
	@PostMapping("/admin/subject/insertSubject")
	public void insertSubject(@RequestBody SubjectModel subject) {
		this.subjectServ.insertSubject(subject);
	}
	
	@DeleteMapping("/admin/subject/deleteSubject/{subjectid}")
	public void deletesubject(@PathVariable String subjectid) {
		//TODO : IMPLEMENTATION
		this.subjectServ.deleteSubject(subjectid);
	}
	
	@GetMapping("/admin/subject/getAll")
	public List<SubjectModel> fetchAllSubjects(){
		return this.subjectServ.getSubjectsAll();
	}
	
	@GetMapping("/admin/subject/getOne/{subjectid}")
	public SubjectModel fetchSubjectInfoByID(@PathVariable String subjectid) {
		return this.subjectServ.getSubjectID(subjectid);
	}
	
	//For Classes
	@PostMapping("/admin/classinfo/insertClassInfo")
	public void insertClassInfo(@RequestBody ClassModel classinfo) {
		this.classServ.insertClassInfo(classinfo);
	}
	
	@DeleteMapping("/admin/classInfo/deleteClassInfo/{classid}")
	public void deleteClassInfo(@PathVariable String classid) {
		//TODO : IMPLEMENTATION
		this.classServ.deleteClassInfo(classid);
	}
	
	@GetMapping("/admin/classInfo/getAll")
	public List<ClassModel> fetchAllClasses(){
		return this.classServ.getAllClasses();
	}
	
	@GetMapping("/admin/classinfo/getOne/{classid}")
	public ClassModel fetchClassInfoByID(@PathVariable String classid) {
		return this.classServ.getClassInfoByID(classid);
	}
	
	/*......... TIMETABLE APIs  .........*/
	
	//For Lectures
	@PostMapping("/schedule/lecture/setlecture")
	public void insertLecture(@RequestBody LectureModel lectureinfo) {
		this.lectureServ.insertLecture(lectureinfo);
	}
	
	@PutMapping("/schedule/lecture/changestatus")
	public void updateLectureStatus(@RequestBody LectureModel lectureinfo) {
		this.lectureServ.updateLecture(lectureinfo);
	}
	
	@GetMapping("/schedule/lecture/getAll")
	public List<LectureModel> getAllLectures(){
		return this.lectureServ.getLectures();
	}
}
