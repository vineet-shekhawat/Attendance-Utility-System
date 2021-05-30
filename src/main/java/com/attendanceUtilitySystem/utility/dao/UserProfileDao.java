package com.attendanceUtilitySystem.utility.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceUtilitySystem.utility.models.profiles.UserProfile;

@Repository
public interface UserProfileDao<Profile extends UserProfile> extends JpaRepository<Profile,String>{

	
}
