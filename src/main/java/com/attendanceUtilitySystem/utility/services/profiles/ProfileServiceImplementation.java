package com.attendanceUtilitySystem.utility.services.profiles;

import java.io.Serializable;
import java.util.List;

import com.attendanceUtilitySystem.utility.dao.profiles.AbstractUserProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceUtilitySystem.utility.models.profiles.TypeOfUser;


@Service
public abstract class ProfileServiceImplementation<Profile extends UserProfile, ID extends Serializable>
		implements ProfileService<Profile,ID>{

	private AbstractUserProfileDao<Profile, ID> userDao;

	@Autowired
	public ProfileServiceImplementation(AbstractUserProfileDao<Profile,ID> userRepo){
		this.userDao = userRepo;
	}

	@Override
	public List<Profile> fetchProfiles(String user_id, TypeOfUser type) {
		return userDao.findAll();
	}

	@Override
	public Boolean updateProfile(Profile account, TypeOfUser type) {
		userDao.save(account);
		return true;
	}

	@Override
	public void addProfile(Profile account, TypeOfUser type) {
		userDao.save(account);
	}
}
