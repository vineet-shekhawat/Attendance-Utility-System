package com.attendanceUtilitySystem.utility.services.profiles;
import com.attendanceUtilitySystem.utility.dao.profiles.StudentProfileDao;
import com.attendanceUtilitySystem.utility.dao.sessions.ClassInfoDao;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentProfileServiceImp extends ProfileServiceImplementation<StudentProfile,String>
implements StudentProfileService {

    private StudentProfileDao studentDao;

    public StudentProfileServiceImp(StudentProfileDao studentDao, ClassInfoDao classDao) {
        super(studentDao);
    }
}
