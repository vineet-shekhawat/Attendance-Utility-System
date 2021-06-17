package com.attendanceUtilitySystem.utility.models.attendance;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceList {
    private LectureModel lecture;
    private List<Student> presentStudents;
    private Long attendanceCount;
}
