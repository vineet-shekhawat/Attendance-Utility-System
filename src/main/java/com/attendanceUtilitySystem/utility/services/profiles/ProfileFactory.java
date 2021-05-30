package com.attendanceUtilitySystem.utility.services.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;


@Component
public class ProfileFactory {

	@Autowired
	private ProfileService<StudentProfile> stuProfile;
	
	@Autowired
	private ProfileService<ProfessorProfile> profProfile;
	
	public ProfileService getUserProfileService(TypeOfUser user){
		switch (user) {
		case Teacher: return profProfile;
		case Student: return stuProfile;
		default: return stuProfile;
			//throw new IllegalArgumentException("Unexpected value: " + );
		}
	}
}