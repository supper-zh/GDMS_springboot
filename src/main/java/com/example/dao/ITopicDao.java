package com.example.dao;


import com.example.entity.Topic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface ITopicDao {
	@Select("select * from t_topic")
	List<Topic> showAllTopic();
	@Select("select * from t_topic where studentId=#{studentId}")
	Topic topicByStudentId(int studentId);
	@Insert("insert t_topic values(null,#{thesisId},#{studentId},#{selectTime})")
	int addTopic(Topic topic);
	@Delete("delete from t_topic where studentId=#{studentId}")
	int deleteTopic(int studentId);
	@Select("select * from t_topic where thesisId=#{thesisId}")
	Topic getInfoByThesisId(int thesisId);
	
	
}
