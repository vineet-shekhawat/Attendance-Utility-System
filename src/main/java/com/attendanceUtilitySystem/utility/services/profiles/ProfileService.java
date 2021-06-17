package com.attendanceUtilitySystem.utility.services.profiles;

import java.io.Serializable;
import java.util.List;

import com.attendanceUtilitySystem.utility.models.profiles.UserProfile;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;
import com.attendanceUtilitySystem.utility.services.profiles.ProfileServiceImplementation;

@Service
public interface ProfileService<Profile extends UserProfile, ID extends Serializable> {

	public Profile fetchProfile(String user_id);
	public String updateProfile(Profile account);

	//ADMIN APIs
	public List<Profile> fetchAllProfiles();
	public String insertProfile(Profile account);
	public String deleteProfile(String user_id);

}
