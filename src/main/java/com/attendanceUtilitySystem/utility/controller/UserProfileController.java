package com.attendanceUtilitySystem.utility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceUtilitySystem.utility.services.profiles.ProfileFactory;
import com.attendanceUtilitySystem.utility.services.sessions.ClassInfoService;
import com.attendanceUtilitySystem.utility.services.sessions.LectureService;
import com.attendanceUtilitySystem.utility.services.sessions.SubjectService;
import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;
import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;
import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@RestController
public class UserProfileController {

	@Autowired
	private ProfileFactory profile;
	
	@Autowired
	private ClassInfoService classServ;
	
	@Autowired
	private LectureService lectureServ;
	
	@Autowired
	private SubjectService subjectServ;
	
	@GetMapping("/home/profile/getProfile")
	public <Profile> List<Profile>  getProfileInfo(@RequestParam(defaultValue = "empty") String user_id, @RequestParam(defaultValue = "empty") TypeOfUser type ){
		return this.profile.getUserProfileService(type).fetchProfiles(user_id,type);
		
	}
	
	@PostMapping("/home/profile/updateProfile/{usertype}")
	public <Profile> void updateProfileForUser(@RequestBody Profile updatedprofile, @PathVariable TypeOfUser usertype) {
		this.profile.getUserProfileService(usertype).updateProfile(updatedprofile,usertype);
	}
	
	
	/*.............ADMIN APIs.........*/
	
	//For Profiles
	@PostMapping("/home/profile/insertProfile/{usertype}")
	public <Profile> void insertProfile(@RequestBody Profile newprofile, @PathVariable TypeOfUser usertype) {
		this.profile.getUserProfileService(usertype).addProfile(newprofile);
	}
	
	//TODO: For deleting profile
	
	//For Subjects
	@PostMapping("/admin/subject/insertSubject")
	public void insertSubject(@RequestBody SubjectModel subject) {
		SubjectModel subject1 = new SubjectModel();
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
