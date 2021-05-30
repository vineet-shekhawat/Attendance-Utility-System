package com.attendanceUtilitySystem.utility.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attendanceUtilitySystem.utility.models.sessions.ClassModel;

@Repository
public interface ClassInfoDao extends JpaRepository<ClassModel,String> {

	@Query(value = "SELECT * FROM class_info_table WHERE class_id = ?1", nativeQuery = true)
	public ClassModel getClassbyClassID(String classid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM class_info_table WHERE class_id = ?1", nativeQuery = true)
	public ClassModel deleteClassbyClassID(String classid);

}
