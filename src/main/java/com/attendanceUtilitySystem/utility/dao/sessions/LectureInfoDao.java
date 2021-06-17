package com.attendanceUtilitySystem.utility.dao.sessions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendanceUtilitySystem.utility.models.sessions.LectureModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LectureInfoDao extends JpaRepository<LectureModel,String>{

    @Query(value = "SELECT * FROM lecture_info_table WHERE classid = ?1 AND dateoflecture = ?2", nativeQuery = true)
    public List<LectureModel> findByClassidAndDate(String classid, LocalDate dateoflecture);

    @Query(value = "SELECT * FROM lecture_info_table WHERE professorid = ?1 AND dateoflecture > ?2", nativeQuery = true)
    public List<LectureModel> findByProfidAndAfterThatDate(String profid, LocalDate dateoflecture);
}
