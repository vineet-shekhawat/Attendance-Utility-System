package com.attendanceUtilitySystem.utility.dao.profiles;

import com.attendanceUtilitySystem.utility.models.profiles.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractUserProfileDao<Profile extends UserProfile, ID extends Serializable>
extends JpaRepository<Profile,ID> {
}
