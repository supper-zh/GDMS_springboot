package com.example.dao;


import com.example.entity.StudentScore;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @date 2022-4-23
 * @author zhangC
 * 添加学生成绩
 * 根据学生id查找学生成绩信息
 * 修改学生成绩
 * 
 *
 */
@Mapper

public interface IStudentScoreDao {
	@Insert("insert into t_student_score values(null,#{studentId},#{thesisResult},#{inputMan})")
	int addStudenScore(StudentScore score);
	@Select("select * from t_student_score where studentId=#{studentId}")
	StudentScore showInfoByStudentId(int studentId);
	@Update("update t_student_score set thesisResult=#{thesisResult},inputMan=#{inputMan} where studentId=#{studentId}")
	int modifyStudentScore(StudentScore score);
}
