package com.attendanceUtilitySystem.utility.services.profiles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.dao.UserProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;
import com.attendanceUtilitySystem.utility.models.profiles.UserProfile;

@Service
public class ProfileServiceImplementation<Profile extends UserProfile> implements ProfileService {
	
	List<Profile> users = new ArrayList<>();
	
	@Autowired
	private UserProfileDao<Profile> userDao;
	
	@Override
	public List<Profile> fetchProfiles(String user_id, TypeOfUser type) {
		return userDao.findAll();
	}

	@Override
	public Boolean updateProfile(Object account, TypeOfUser type) {
		
		return null;
	}

	@Override
	public void addProfile(Object account) {
		userDao.save((Profile) account);
		
	}
}
