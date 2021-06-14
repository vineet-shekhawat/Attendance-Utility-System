package com.attendanceUtilitySystem.utility.services.profiles;
import com.attendanceUtilitySystem.utility.dao.profiles.ProfessorProfileDao;
import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import org.springframework.stereotype.Service;

@Service
public class ProfessorProfileServiceImp extends ProfileServiceImplementation<ProfessorProfile,String>
implements ProfessorProfileService {
    private ProfessorProfileDao profDao;

    public ProfessorProfileServiceImp(ProfessorProfileDao profDao) {
        super(profDao);
    }
}
