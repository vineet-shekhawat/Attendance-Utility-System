package com.attendanceUtilitySystem.utility.services.profiles;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;
import com.attendanceUtilitySystem.utility.services.profiles.ProfileServiceImplementation;

@Service
public interface ProfileService<Profile> {

	public List<Profile> fetchProfiles(String user_id, TypeOfUser type);
	public Boolean updateProfile(Profile account, TypeOfUser type);
	public void addProfile(Profile account);
}
