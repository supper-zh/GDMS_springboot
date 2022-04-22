package com.example.dao;


import com.example.entity.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @date 2022-4-23
 * @author zhangC
 * 添加教师
 * 查询教师 根据id
 * 查询所有教师信息
 * 删除教师
 * 更新教师
 * 查询教师信息 根据 编号、姓名、编号和姓名
 *
 * @author zhangC
 * 查询教师的信息 根据教师no
 * 
 *
 */
@Mapper
@Repository
public interface ITeacherDao {
	@Insert("insert into t_teacher values(null,#{teacherNo},#{teacherName},#{departmentId},#{sex},#{inputMan},#{lastModifyTime},#{phone},#{email},#{zhicheng})")
	int addTeacher(Teacher teacher);
	@Select("select * from t_teacher where id=#{id}")
	Teacher selectTeacher(int id);
	@Select("select * from t_teacher")
	List<Teacher> showAllTeacher();

	@Delete("delete from t_teacher where id=#{id}")
	int deleteTeacher(int id);

	@Update("update t_teacher set teacherNo=#{teacherNo},teacherName=#{teacherName},departmentId=#{departmentId},sex=#{sex},inputMan=#{inputMan},lastModifyTime=#{lastModifyTime},phone=#{phone},email=#{email},zhicheng=#{zhicheng} where id=#{id}")
	int updateTeacher(Teacher teacher);
	@Select("select * from t_teacher where teacherNo=#{teacherNo}")
	List<Teacher> showTeacherOne1(String teacherNo);
	@Select("select * from t_teacher where teacherName=#{teacherName}")
	List<Teacher> showTeacherOne2(String teacherName);
	@Select("select * from t_teacher where teacherNo=#{teacherNo} and teacherName=#{teacherName}")
	List<Teacher> showTeacherOne3(@Param("teacherNo") String teacherNo, @Param("teacherName") String teacherName);

	@Select("select * from t_teacher where teacherNo=#{teacherNo}")
	Teacher teacherInfoByNo(String teacherNo);
	
	
	
}
