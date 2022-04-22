package com.example.dao;

import com.example.entity.ThesisInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


/**
 * @date 2022-4-23
 * @author zhangC
 * 添加学生提交论文信息
 * 通过学生提交论文信息
 * 未通过学生提交论文信息
 * 删除学生提交论文信息
 * 根据学生id查找学生论文信息
 * 根据论文path查找学生论文信息
 *
 */
@Mapper
@Repository
public interface IThesisInformationDao {
	@Insert("insert into t_thesis_information values(null,#{studentId},#{thesisText},0,#{description});")
	int addThesisInformation(ThesisInformation thesisInformation);
	@Update("update t_thesis_information set status=2 where studentId=#{studentId}")
	int passThesisInformation(int studentId);
	@Update("update t_thesis_information set status=1 where studentId=#{studentId}")
	int failThesisInformation(int studentId);
	@Delete("delete from t_thesis_information where studentId=#{studentId}")
	int deleteThesisInformation(int studentId);
	@Select("select * from t_thesis_information where studentId=#{studentId}")
	ThesisInformation getInfoByStudentId(int studentId);
	@Select("select * from t_thesis_information where thesisText=#{thesisText}")
	ThesisInformation getInfoByFilePath(String thesisText);
}
