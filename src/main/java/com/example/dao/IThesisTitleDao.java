package com.example.dao;


import com.example.entity.ThesisTitle;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangC
 * 添加课题
 * 根据教师id 查找课题List
 * 根据课题编号查找课题信息
 * 更新课题
 * 删除课题
 * 查找所有的课题(admin查询)
 * 修改status属性 (1==>未审核   2==>审核通过   3==> 审核不通过)
 * 
 * 
 *
 */
@Mapper
public interface IThesisTitleDao {
@Insert("insert into t_thesis_title values(null,#{thesisName},#{teacherId},#{submitTime},1,#{inputMan},#{nandu},#{liang},#{from},#{leixing},#{description})")
	int addThesisTitle(ThesisTitle thesisTitle);
	@Select("select * from t_thesis_title where teacherId=#{teacherId}")
	List<ThesisTitle> showAllThesisTitle(int id);
	@Select("select * from t_thesis_title where id=#{id}")
	ThesisTitle getThesisById(int id);
	@Update("update t_thesis_title set thesisName=#{thesisName},teacherId=#{teacherId},submitTime=#{submitTime},status=#{status},inputMan=#{inputMan},nandu=#{nandu},from=#{from},liang=#{liang},leixing=#{leixing},description=#{description} where id=#{id}")
	int updateThesisTitle(ThesisTitle thesisTitle);
	@Delete("delete from t_thesis_title where id=#{id}")
	int deleteThesisTitle(int id);
	@Select("select * from t_thesis_title")
	List<ThesisTitle> showAllThesisTitleAd();
	@Update("update t_thesis_title set status = 2 where id=#{id}")
	int agreeThesis(int id);
	@Update("update t_thesis_title set status = 3 where id=#{id}")
	int disagreeThesis(int id);
	
}
