package com.attendanceUtilitySystem.utility.controller;

import com.attendanceUtilitySystem.utility.models.attendance.AttendanceList;
import com.attendanceUtilitySystem.utility.models.attendance.MarkAttendance;
import com.attendanceUtilitySystem.utility.services.attendance.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttendanceMgmtController {

    @Autowired
    private attendanceService attendanceservice;

    @PostMapping("/attendance/student/markattendance")
    public void markAttendanceForStudents(@RequestBody MarkAttendance student){
        this.attendanceservice.markAttendance(student);
    }

    @GetMapping("/attendance/professor/getAttendanceList/{lectureid}")
    public ResponseEntity<AttendanceList> getAttendanceList(@PathVariable String lectureid){
        return this.attendanceservice.fetchStudentsAttendedLecture(lectureid);
    }
}
