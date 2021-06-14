package com.attendanceUtilitySystem.utility.dao.sessions;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attendanceUtilitySystem.utility.models.sessions.SubjectModel;

@Repository
public interface SubjectInfoDao extends JpaRepository<SubjectModel,String> {

	@Query(value = "SELECT * FROM subject_info_table WHERE Subject_ID = ?1", nativeQuery = true)
	public SubjectModel getSubjectbySubjectID(String subjectid);

	@Transactional
	@Query(value = "DELETE FROM subject_info_table WHERE Subject_ID = ?1", nativeQuery = true)
	public SubjectModel deleteSubjectbySubjectID(String subjectid);
}