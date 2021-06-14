package com.attendanceUtilitySystem.utility.services.profiles;

import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import org.springframework.stereotype.Service;

@Service
public interface StudentProfileService extends ProfileService<StudentProfile,String> {
}
