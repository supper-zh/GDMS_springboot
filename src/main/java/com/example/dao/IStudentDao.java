package com.example.dao;


import com.example.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangh
 * 
 * 查询学生信息根据id
 * 添加学生
 * 查询全部学生
 * 删除学生
 * 更新学生
 * 查询学生信息根据 编号、姓名、编号和姓名
 * 根据no查询学生信息
 *
 */
@Mapper
public interface IStudentDao {

	@Select("select * from t_student where id=#{id}")
	Student selectStudent(@Param("id") int id);

	@Insert("insert into t_student values(null,#{studentNo},#{studentName},#{sex},#{majorId},#{grade},#{inputMan},#{lastModifyTime},#{phone},#{email})")
	int addStudent(@Param("student") Student student);

	@Select("select * from t_student")
	List<Student> showAllStudent();

	@Delete("delete from t_student where id=#{id}")
	int deleteStudent(@Param("id") int id);

	@Update("update t_student set studentNo=#{studentNo},studentName=#{studentName},sex=#{sex},majorId=#{majorId},grade=#{grade},inputMan=#{inputMan},lastModifyTime=#{lastModifyTime},phone=#{phone},email=#{email} where id=#{id}")
	int updateStudent(@Param("student") Student student);

	@Select("select * from t_student where studentNo=#{studentNo}")
	List<Student> showStudentOne1(@Param("studentNo") String studentNo);

	@Select("select * from t_student where studentName=#{studentName}")
	List<Student> showStudentOne2(@Param("studentName") String studentName);


	@Select("select * from t_student where studentNo=#{studentNo} and studentName=#{studentName}")
	List<Student> showStudentOne3(@Param("studentNo") String studentNo, @Param("studentName") String studentName);

	@Select("select * from t_student where studentNo=#{studentNo}")
	Student getInfoByNo(@Param("studentNo") String studentNo);
	
	
}
