package com.example.dao;


import com.example.entity.TeacherTaskBookOpening;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangC
 * 根据 thesisTitleId 查询所有信息
 * 添加任务书信息
 * 添加开题报告信息
 * 根据thesisTitleId更新opening的信息
 * 根据thesisTitleId更新taskBook的信息
 * 根据教师id 获得所有信息
 * 根据thesisTitleId 把taskBook 设置为null
 * 根据thesisTitleId 把opening 设置为null
 * 根据thesisTitleId 查询所有信息
 * 根据thesisTitleId 删除所有信息
 * 根据taskBook 查询信息
 * 根据openingReport 查询信息
 * 
 *
 */
@Mapper
@Repository
public interface ITeacherTaskBookOpeningDao {
	@Select("select * from t_teacher_opening_report_task_book where thesisTitleId=#{thesisTitleId}")
	TeacherTaskBookOpening showInfo(int thesisTitleId);
@Select("insert into t_teacher_opening_report_task_book values(null,#{teacherId},null,#{taskBook},null,null,null,null,#{description},#{thesisTitleId})")
	int addTaskBook(TeacherTaskBookOpening teacherTaskBookOpening);
	@Insert("insert into t_teacher_opening_report_task_book values(null,#{teacherId},#{openingReport},null,null,null,null,null,#{description},#{thesisTitleId})")
	int addOpening(TeacherTaskBookOpening teacherTaskBookOpening);
	@Insert("insert into t_teacher_opening_report_task_book values(null,#{teacherId},null,null,#{keXingXing},null,null,null,#{description},#{thesisTitleId})")
	int addKeXingXing(TeacherTaskBookOpening teacherTaskBookOpening);
	@Insert("insert into t_teacher_opening_report_task_book values(null,#{teacherId},null,null,null,#{xuQiu},null,null,#{description},#{thesisTitleId})")
	int addXuQiu(TeacherTaskBookOpening teacherTaskBookOpening);
	@Insert("insert into t_teacher_opening_report_task_book values(null,#{teacherId},null,null,null,null,#{gaiYao},null,#{description},#{thesisTitleId})")
	int addGaiYao(TeacherTaskBookOpening teacherTaskBookOpening);
	@Insert("insert into t_teacher_opening_report_task_book values(null,#{teacherId},null,null,null,null,null,#{shuJuKu},#{description},#{thesisTitleId})")
	int addShuJuKu(TeacherTaskBookOpening teacherTaskBookOpening);
	@Update("update t_teacher_opening_report_task_book set taskBook=#{taskBook} where thesisTitleId=#{thesisTitleId}")
	int uploadTaskBook(TeacherTaskBookOpening teacherTaskBookOpening);
	@Update("update t_teacher_opening_report_task_book set openingReport=#{openingReport} where thesisTitleId=#{thesisTitleId}")
	int uploadOpening(TeacherTaskBookOpening teacherTaskBookOpening);
	@Update("update t_teacher_opening_report_task_book set keXingXing=#{keXingXing} where thesisTitleId=#{thesisTitleId}")
	int uploadKeXingXing(TeacherTaskBookOpening teacherTaskBookOpening);
	@Update("update t_teacher_opening_report_task_book set xuQiu=#{xuQiu} where thesisTitleId=#{thesisTitleId}")
	int uploadXuQiu(TeacherTaskBookOpening teacherTaskBookOpening);
	@Update("update t_teacher_opening_report_task_book set gaiYao=#{gaiYao} where thesisTitleId=#{thesisTitleId}")
	int uploadGaiYao(TeacherTaskBookOpening teacherTaskBookOpening);
	@Update("update t_teacher_opening_report_task_book set shuJuKu=#{shuJuKu} where thesisTitleId=#{thesisTitleId}")
	int uploadShuJuKu(TeacherTaskBookOpening teacherTaskBookOpening);

	@Select("select * from t_teacher_opening_report_task_book where teacherId=#{teacherId}")
	List<TeacherTaskBookOpening> showTeacherTaskBookOpeningById(int teacherId);


//	@Update("update t_teacher_opening_report_task_book set taskBook=\"\" where thesisTitleId=#{thesisTitleId}")
//	int resetTaskBook(int thesisTitleId);
//	@Update("update t_teacher_opening_report_task_book set openingReport=\"\" where thesisTitleId=#{thesisTitleId}")
//	int resetOpening(int thesisTitleId);
//	@Update("update t_teacher_opening_report_task_book set keXingXing=\"\" where thesisTitleId=#{thesisTitleId}")
//	int resetKeXingXing(int thesisTitleId);
//	@Update("update t_teacher_opening_report_task_book set xuQiu=\"\" where thesisTitleId=#{thesisTitleId}")
//	int resetXuQiu(int thesisTitleId);
//	@Update("update t_teacher_opening_report_task_book set gaiYao=\"\" where thesisTitleId=#{thesisTitleId}")
//	int resetGaiYao(int thesisTitleId);
//	@Update("update t_teacher_opening_report_task_book set shuJuKu=\"\" where thesisTitleId=#{thesisTitleId}")
//	int resetShuJuKu(int thesisTitleId);
@Update("update t_teacher_opening_report_task_book set taskBook=null where thesisTitleId=#{thesisTitleId}")
int resetTaskBook(int thesisTitleId);
	@Update("update t_teacher_opening_report_task_book set openingReport=null where thesisTitleId=#{thesisTitleId}")
	int resetOpening(int thesisTitleId);
	@Update("update t_teacher_opening_report_task_book set keXingXing=null where thesisTitleId=#{thesisTitleId}")
	int resetKeXingXing(int thesisTitleId);
	@Update("update t_teacher_opening_report_task_book set xuQiu=null where thesisTitleId=#{thesisTitleId}")
	int resetXuQiu(int thesisTitleId);
	@Update("update t_teacher_opening_report_task_book set gaiYao=null where thesisTitleId=#{thesisTitleId}")
	int resetGaiYao(int thesisTitleId);
	@Update("update t_teacher_opening_report_task_book set shuJuKu=null where thesisTitleId=#{thesisTitleId}")
	int resetShuJuKu(int thesisTitleId);

	@Select("select * from t_teacher_opening_report_task_book where thesisTitleId=#{thesisTitleId}")
	TeacherTaskBookOpening showInfoByThesisId(int thesisTitleId);
	@Delete("delete from t_teacher_opening_report_task_book where thesisTitleId=#{thesisTitleId}")
	int deleteInfo(int thesisTitleId);
	@Select("select * from t_teacher_opening_report_task_book where taskBook=#{taskBook}")
	TeacherTaskBookOpening getTheisIdByTask(String taskBook);
	@Select("select * from t_teacher_opening_report_task_book where openingReport=#{openingReport}")
	TeacherTaskBookOpening getTheisIdByOpening(String openingReport);
	@Select("select * from t_teacher_opening_report_task_book where keXingXing=#{keXingXing}")
	TeacherTaskBookOpening getTheisIdByKeXingXing(String keXingXing);
	@Select("select * from t_teacher_opening_report_task_book where xuQiu=#{xuQiu}")
	TeacherTaskBookOpening getTheisIdByXuQiu(String xuQiu);
	@Select("select * from t_teacher_opening_report_task_book where gaiYao=#{gaiYao}")
	TeacherTaskBookOpening getTheisIdByGaiYao(String gaiYao);
	@Select("select * from t_teacher_opening_report_task_book where shuJuKu=#{shuJuKu}")
	TeacherTaskBookOpening getTheisIdByShuJuKu(String shuJuKu);
	
}
