package com.example.dao;


import com.example.entity.TeacherProgress;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangC
 * 添加进度信息
 * 通过进度
 * 未通过进度
 * 根据学生id获得进度信息
 * 根据教师id获得进度信息
 * 
 *
 */
@Mapper
@Repository
public interface ITeacherProgressDao {
	@Insert("insert into t_teacher_progress_notification values (null,#{context},#{inputMan},#{inputTime},#{studentId},#{teacherId},0)")
	int addTeacherProgress(TeacherProgress teacherProgress);
	@Update("update t_teacher_progress_notification set state=2 where id=#{id}")
	int passTeacherProgress(int id);
	@Update("update t_teacher_progress_notification set state=1 where id=#{id}")
	int failTeacherProgress(int id);
	@Select("select * from t_teacher_progress_notification where studentId=#{studentId}")
	List<TeacherProgress> getInfoByStudentId(int studentId);
	@Select("select * from t_teacher_progress_notification where teacherId=#{teacherId}")
	List<TeacherProgress> getInfoByTeacherId(int teacherId);
	
}
