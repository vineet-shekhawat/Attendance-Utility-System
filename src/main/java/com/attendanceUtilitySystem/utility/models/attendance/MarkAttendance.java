package com.attendanceUtilitySystem.utility.models.attendance;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Document(collection = "IndividualStudentAttendance")
public class MarkAttendance {
    @Id
    @GeneratedValue
    private String id;
    private String lectureid;
    @JsonFormat(pattern = "hh:mm:ss")
    private LocalTime timeAtMarkingAttendance;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate DateofLecture;
    private Student student;
}
