package com.attendanceUtilitySystem.utility.controller;

import java.util.List;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
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


@RestController
public class UserProfileController {

	@Autowired
	private ProfessorProfileService profServ;

	@Autowired
	private StudentProfileService studentServ;

	//Student and Professor APIs

	@GetMapping("/home/profile/student/getProfile/{studentid}")
	public StudentProfile getStudentProfile(@PathVariable String studentid){
		return this.studentServ.fetchProfile(studentid);
	}

	@GetMapping("/home/profile/professor/getProfile/{profid}")
	public ProfessorProfile getProfessorProfile(@PathVariable String profid){
		return this.profServ.fetchProfile(profid);
	}

	@PutMapping("/home/profile/professor/updateProfile")
	public void updateProfileForUser(@RequestBody ProfessorProfile profile) {
		this.profServ.updateProfile(profile);
	}

	@PutMapping("/home/profile/student/updateProfile")
	public void updateProfileForUser(@RequestBody StudentProfile profile) {
		this.studentServ.updateProfile(profile);
	}
}
