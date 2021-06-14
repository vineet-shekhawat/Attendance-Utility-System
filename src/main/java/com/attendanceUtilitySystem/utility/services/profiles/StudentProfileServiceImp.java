package com.attendanceUtilitySystem.utility.services.profiles;
import com.attendanceUtilitySystem.utility.dao.profiles.StudentProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImp extends ProfileServiceImplementation<StudentProfile,String>
implements StudentProfileService {

    private StudentProfileDao studentDao;
    public StudentProfileServiceImp(StudentProfileDao studentDao) {
        super(studentDao);
    }
}
