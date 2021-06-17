package com.attendanceUtilitySystem.utility.controller;

import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;
import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;
import com.attendanceUtilitySystem.utility.services.sessions.ClassInfoService;
import com.attendanceUtilitySystem.utility.services.sessions.LectureService;
import com.attendanceUtilitySystem.utility.services.sessions.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LectureSetupController {
    @Autowired
    private ClassInfoService classServ;

    @Autowired
    private LectureService lectureServ;

    @Autowired
    private SubjectService subjectServ;

    //For Classes
    @GetMapping("/home/classinfo/basic/getOne/{classid}")
    public ClassModel fetchClassInfoByID(@PathVariable String classid) {
        return this.classServ.getClassBasicInfoByID(classid);
    }

    @GetMapping("/home/classinfo/withStudents/getOne/{classid}")
    public ClassModel fetchClassInfoWithStudentsByID(@PathVariable String classid) {
        return this.classServ.ClassInfoWithStudentsByID(classid);
    }

    //For Subject

    @GetMapping("/admin/subject/getOne/{subjectid}")
    public SubjectModel fetchSubjectInfoByID(@PathVariable String subjectid) {
        return this.subjectServ.getSubjectID(subjectid);
    }

    //For Lectures
    @PostMapping("/schedule/lecture/setlecture")
    public void insertLecture(@RequestBody LectureModel lectureinfo) {
        this.lectureServ.insertLectureForTomorrow(lectureinfo);
    }

    @PutMapping("/schedule/lecture/updateLecture/time")
    public void updateLectureStatus(@RequestBody LectureModel lectureinfo) {
        this.lectureServ.updateLectureTime(lectureinfo);
    }

    @GetMapping("/schedule/lecture/student/{classid}")
    public List<LectureModel> getAllLectures(@PathVariable String classid){
        return this.lectureServ.getLecturesForStudents(classid);
    }

    @GetMapping("/schedule/lecture/professor/days")
    public List<LectureModel> getAllLecturesForProfessor(@RequestParam String classid, @RequestParam Integer noOfDays){
        return this.lectureServ.getLecturesForProfessor(classid, noOfDays);
    }

    @PutMapping("/schedule/lecture/updateLecture/cancel/{lectureid}")
    public void cancelLectureByProfessor(@PathVariable String lectureid){
        this.lectureServ.cancelLecture(lectureid);
    }
}
