package com.example.dao;


import com.example.entity.Zhiyuan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @date 2022-4-23
 * @author zhangC
 * 获得所有的已选课题信息
 * 根据学生id获得选题信息
 * 添加选题信息
 * 根据学生id 删除选题信息
 * 
 */
@Mapper
public interface IZhiyuanDao {
	@Select("select * from t_zhiyuan join t_student on t_zhiyuan.studentId=t_student.id join t_thesis_title on t_zhiyuan.thesisId=t_thesis_title.id  where teacherId=#{teacherId}")
	List<Map> showAllZhiyuan(int teacherId);
	@Select("select * from t_zhiyuan where studentId=#{studentId}")
	Zhiyuan zhiyuanByStudentId(int studentId);
	@Insert("insert t_zhiyuan values(null,#{thesisId},#{studentId},#{selectTime})")
	int addZhiyuan(Zhiyuan zhiyuan);
	@Delete("delete from t_zhiyuan where studentId=#{studentId}")
	int deleteZhiyuan(int studentId);
	@Select("select * from t_zhiyuan where thesisId=#{thesisId}")
	Zhiyuan getInfoByThesisId(int thesisId);
	
	
}
