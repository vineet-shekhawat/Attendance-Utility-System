package com.attendanceUtilitySystem.utility.dao.mongo;
import com.attendanceUtilitySystem.utility.models.attendance.MarkAttendance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttendanceDao extends MongoRepository<MarkAttendance,String> {
   public List<MarkAttendance> findByLectureid(String lectureid);
}
