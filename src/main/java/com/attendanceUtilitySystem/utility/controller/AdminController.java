package com.attendanceUtilitySystem.utility.controller;

import com.attendanceUtilitySystem.utility.models.profiles.ProfessorProfile;
import com.attendanceUtilitySystem.utility.models.profiles.StudentProfile;
import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;
import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;
import com.attendanceUtilitySystem.utility.services.profiles.ProfessorProfileService;
import com.attendanceUtilitySystem.utility.services.profiles.StudentProfileService;
import com.attendanceUtilitySystem.utility.services.sessions.ClassInfoService;
import com.attendanceUtilitySystem.utility.services.sessions.LectureService;
import com.attendanceUtilitySystem.utility.services.sessions.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO
@RestController
public class AdminController {

    @Autowired
    private ProfessorProfileService professorService;

    @Autowired
    private StudentProfileService studentService;

    @Autowired
    private ClassInfoService classService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private SubjectService subjectService;

    //Student and Professor ADMIN APIs
    @GetMapping("/admin/professor/getAllProfile")
    public List<ProfessorProfile> getAllProfessorProfile(){
        return this.professorService.fetchAllProfiles();
    }

    @GetMapping("/admin/student/getAllProfile")
    public List<StudentProfile> getAllStudentProfile(){
        return this.studentService.fetchAllProfiles();
    }

    @PostMapping("/admin/professor/insertProfile")
    public void insertProfessorProfile(@RequestBody ProfessorProfile newprofile) {
        this.professorService.insertProfile(newprofile);
    }

    @PostMapping("/admin/student/insertProfile")
    public void insertStudentProfile(@RequestBody StudentProfile newprofile) {
        this.studentService.insertProfile(newprofile);
    }

    @DeleteMapping("/admin/professor/deleteProfile/{studentid}")
    public void deleteProfessorProfile(@PathVariable String studentid) {
        this.professorService.deleteProfile(studentid);
    }

    @DeleteMapping("/admin/student/deleteProfile/{profid}")
    public void deleteStudentProfile(@PathVariable String profid) {
        this.studentService.deleteProfile(profid);
    }

    //ClassInfo and SubjectInfo ADMIN APIs

    @PostMapping("/admin/classinfo/insertClassInfo")
    public void insertClassInfo(@RequestBody ClassModel classinfo) {
        this.classService.insertClassInfo(classinfo);
    }

    @DeleteMapping("/admin/classInfo/deleteClassInfo/{classid}")
    public void deleteClassInfo(@PathVariable String classid) {
        this.classService.deleteClassInfo(classid);
    }

    @GetMapping("/admin/classInfo/getAll")
    public List<ClassModel> fetchAllClasses(){
        return this.classService.getAllClasses();
    }

    @PostMapping("/admin/subject/insertSubject")
    public void insertSubject(@RequestBody SubjectModel subject) {
        this.subjectService.insertSubject(subject);
    }

    @DeleteMapping("/admin/subject/deleteSubject/{subjectid}")
    public void deletesubject(@PathVariable String subjectid) {
        this.subjectService.deleteSubject(subjectid);
    }

    @GetMapping("/admin/subject/getAll")
    public List<SubjectModel> fetchAllSubjects(){
        return this.subjectService.getSubjectsAll();
    }

}
