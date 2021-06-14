package com.attendanceUtilitySystem.utility.dao.profiles;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorProfileDao extends AbstractUserProfileDao<ProfessorProfile,String> {

}
