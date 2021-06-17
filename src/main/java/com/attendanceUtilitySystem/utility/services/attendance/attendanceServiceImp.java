package com.attendanceUtilitySystem.utility.services.attendance;

import com.attendanceUtilitySystem.utility.dao.mongo.AttendanceDao;
import com.attendanceUtilitySystem.utility.dao.profiles.StudentProfileDao;
import com.attendanceUtilitySystem.utility.dao.sessions.LectureInfoDao;
import com.attendanceUtilitySystem.utility.models.attendance.AttendanceList;
import com.attendanceUtilitySystem.utility.models.attendance.MarkAttendance;
import com.attendanceUtilitySystem.utility.models.attendance.Student;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class attendanceServiceImp implements attendanceService{
    @Autowired
    private AttendanceDao attendancerepository;

    @Autowired
    private LectureInfoDao lecturerepository;

    @Autowired
    private StudentProfileDao studentrepository;

    @Override
    public String markAttendance(MarkAttendance student) {
        if(lecturerepository.findById(student.getLectureid()).isPresent()){
            LectureModel lecture = lecturerepository.getOne(student.getLectureid());
            if( lecture.getLectureCancelled()==false &&
                    student.getDateofLecture().isEqual(lecture.getDateOfLecture()) &&
                    student.getTimeAtMarkingAttendance().isAfter(lecture.getStartTime())  &&
                    student.getTimeAtMarkingAttendance().isBefore(lecture.getEndTime()) ) {

                if (studentrepository.findById(student.getStudent().getRollno()).isPresent()) {
                    StudentProfile tmpStudent = studentrepository.getOne(student.getStudent().getRollno());
                    if (tmpStudent.getClassinfo().getClassid().equals(lecture.getClassinfo().getClassid()) &&
                            tmpStudent.getUsername().equals(student.getStudent().getName())) {
                        attendancerepository.save(student);
                        return "attendance marking is done";
                    }
                }
            }
           // attendancerepository.save(student);
        }
        return "marking attendance failed, try again later";
    }

    @Override
    public ResponseEntity<AttendanceList> fetchStudentsAttendedLecture(String lectureid) {
        List<Student> students = new ArrayList<>();
        if(lecturerepository.findById(lectureid).isPresent()){
            attendancerepository.findByLectureid(lectureid).forEach(studentAttended ->
                    students.add(studentAttended.getStudent()));

            AttendanceList attendanceList = new AttendanceList();
            attendanceList.setLecture(lecturerepository.getOne(lectureid));
            attendanceList.setPresentStudents(students);
            attendanceList.setAttendanceCount((long) students.size());

            return new ResponseEntity<>(attendanceList, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
