package com.attendanceUtilitySystem.utility.services.profiles;

import java.io.Serializable;
import java.util.List;

import com.attendanceUtilitySystem.utility.dao.profiles.AbstractUserProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public abstract class ProfileServiceImplementation<Profile extends UserProfile, ID extends Serializable>
		implements ProfileService<Profile,ID>{

	private AbstractUserProfileDao<Profile, ID> userDao;

	@Autowired
	public ProfileServiceImplementation(AbstractUserProfileDao<Profile,ID> userRepo){
		this.userDao = userRepo;
	}

	@Override
	public Profile fetchProfile(String user_id) {
		if(userDao.findById((ID) user_id).isPresent()){
			return userDao.getOne((ID) user_id);
		}
		return null;
	}

	@Override
	@Transactional
	public String updateProfile(Profile account) {
		if(userDao.findById((ID) account.getUser_id()).isPresent()){
			userDao.save(account);
			return "Profile Updated";
		}
		return "Profile doesn't exists";

	}

	@Override
	public List<Profile> fetchAllProfiles() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public String insertProfile(Profile account) {
		if(userDao.findById((ID) account.getUser_id()).isPresent()){
			return "Profile already exists";
		} else{
			userDao.save(account);
			return "Profile inserted successfully";
		}
	}

	@Override
	@Transactional
	public String deleteProfile(String user_id) {
		if(userDao.findById((ID) user_id).isPresent()){
			userDao.deleteById((ID) user_id);
			return "Profile exists, now deleted successfully";
		} else{
			return "Profile doesn't exists";
		}
	}
}
