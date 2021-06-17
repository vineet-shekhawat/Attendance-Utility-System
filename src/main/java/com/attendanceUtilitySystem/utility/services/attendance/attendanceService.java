package com.attendanceUtilitySystem.utility.services.attendance;
import com.attendanceUtilitySystem.utility.models.attendance.AttendanceList;
import com.attendanceUtilitySystem.utility.models.attendance.MarkAttendance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface attendanceService {
    public String markAttendance(MarkAttendance student);
    public ResponseEntity<AttendanceList> fetchStudentsAttendedLecture(String lectureid);
}
