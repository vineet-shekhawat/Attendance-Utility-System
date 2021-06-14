package com.attendanceUtilitySystem.utility.dao.profiles;

import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileDao extends AbstractUserProfileDao<StudentProfile,String> {

}
