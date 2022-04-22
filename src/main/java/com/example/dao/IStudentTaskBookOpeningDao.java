package com.example.dao;

import com.example.entity.StudentTaskBookOpening;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @date 2022-4-23
 * @author zhangC
 * 根据学生id 获得信息
 * 插入信息 只添加学生id
 * 通过学生id修改任务书路径
 * 通过学生id修改开题报告路径
 * 重置任务书路径
 * 重置开题报告路径
 * 根据任务书路径查找信息
 * 根据开题报告路径查找信息
 * 根据学生id 修改审核状态(1-->不通过 2--> 通过 )
 *
 */
@Mapper
@Repository
public interface IStudentTaskBookOpeningDao {
	@Select("select * from t_student_opening_report_task_book where studentId=#{studentId}")
	StudentTaskBookOpening showInfoByStudentId(int studentId);

	@Insert("insert into t_student_opening_report_task_book values(null,#{studentId},null,null,null,null,null,null,null,null,null,null,null,null,null)")
	int addInfoByStudentId(int studentId);


	@Select("select * from t_thesis_title join t_topic on t_thesis_title.id = t_topic.thesisId join t_student on t_topic.studentId = t_student.id join t_student_opening_report_task_book on t_topic.studentId = t_student_opening_report_task_book.studentId where teacherId=#{teacherId}")
	List<Map> showAllScores(int teacherId);

	@Select("select * from t_student_opening_report_task_book")
	List<StudentTaskBookOpening> showAllInfo();

	@Update("update t_student_opening_report_task_book set studentTaskBook=#{studentTaskBook} where studentId=#{studentId}")
	int uploadTaskBook(@Param("studentId") int studentId,@Param("studentTaskBook") String studentTaskBook);
	@Update("update t_student_opening_report_task_book set studentOpeningResport=#{studentOpeningResport} where studentId=#{studentId}")
	int uploadOpening(@Param("studentId") int studentId,@Param("studentOpeningResport") String studentOpeningResport);
	@Update("update t_student_opening_report_task_book set studentKeXingXing=#{studentKeXingXing} where studentId=#{studentId}")
	int uploadKeXingXing(@Param("studentId") int studentId,@Param("studentKeXingXing") String studentKeXingXing);
	@Update("update t_student_opening_report_task_book set studentXuQiu=#{studentXuQiu} where studentId=#{studentId}")
	int uploadXuQiu(@Param("studentId") int studentId,@Param("studentXuQiu") String studentXuQiu);
	@Update("update t_student_opening_report_task_book set studentGaiYao=#{studentGaiYao} where studentId=#{studentId}")
	int uploadGaiYao(@Param("studentId") int studentId,@Param("studentGaiYao") String studentGaiYao);
	@Update("update t_student_opening_report_task_book set studentShuJuKu=#{studentShuJuKu} where studentId=#{studentId}")
	int uploadShuJuKu(@Param("studentId") int studentId,@Param("studentShuJuKu") String studentGaiYao);

	int ShuJuKu(@Param("studentId") int studentId,@Param("studentShuJuKu") String studentShuJuKu);


//这块将注解中的“”换成了null
	@Update("update t_student_opening_report_task_book set studentTaskBook=null where studentId=#{studentId}")
	int resetTaskBook(@Param("studentId") int studentId);
	@Update("update t_student_opening_report_task_book set studentOpeningResport=null where studentId=#{studentId}")
	int resetOpening(int studentId);
	@Update("update t_student_opening_report_task_book set studentKeXingXing=null where studentId=#{studentId}")
	int resetKeXingXing(int studentId);
	@Update("update t_student_opening_report_task_book set studentXuQiu=null where studentId=#{studentId}")
	int XuQiu(int studentId);
	@Update("update t_student_opening_report_task_book set studentGaiYao=null where studentId=#{studentId}")
	int resetGaiYao(int studentId);
	@Update("update t_student_opening_report_task_book set studentShuJuKu=null where studentId=#{studentId}")
	int resetShuJuKu(int studentId);
	//


	@Select("select * from t_student_opening_report_task_book where studentTaskBook=#{studentTaskBook}")
	StudentTaskBookOpening getInfoByTaskBookPath(String studentTaskBook);
	@Select("select * from t_student_opening_report_task_book where studentOpeningResport=#{studentOpeningResport}")
	StudentTaskBookOpening getInfoByOpeningPath(String studentOpeningResport);
	@Select("select * from t_student_opening_report_task_book where studentKeXingXing=#{studentKeXingXing}")
	StudentTaskBookOpening getInfoByKeXingXingPath(String studentKeXingXing);
	@Select("select * from t_student_opening_report_task_book where studentXuQiu=#{studentXuQiu}")
	StudentTaskBookOpening getInfoByXuQiuPath(String studentXuQiuResport);


	@Select("select * from t_student_opening_report_task_book where studentGaiYao=#{studentGaiYao}")
	StudentTaskBookOpening getInfoByGaiYaoPath(String studentGaiYaoResport);


	@Select("select * from t_student_opening_report_task_book where studentShuJuKu=#{studentShuJuKu}")
	StudentTaskBookOpening getInfoByShuJuKuPath(String studentShuJuKuResport);
	@Update("update t_student_opening_report_task_book set openscore=#{openscore} where studentId=#{studentId}")
	int passOpening(@Param("studentId") int studentId,@Param("openscore") String openscore);
	@Update("update t_student_opening_report_task_book set kexingscore=#{kexingscore} where studentId=#{studentId}")
	int passKexing(@Param("studentId") int studentId,@Param("kexingscore") String kexingscore);
	@Update("update t_student_opening_report_task_book set xuqiuscore=#{xuqiuscore} where studentId=#{studentId}")
	int passXuqiu(@Param("studentId") int studentId,@Param("xuqiuscore") String xuqiuscore);

	@Update("update t_student_opening_report_task_book set gaiyaoscore=#{gaiyaoscore} where studentId=#{studentId}")
	int passGaiyao(@Param("studentId") int studentId,@Param("gaiyaoscore") String gaiyaoscore);


	@Update("update t_student_opening_report_task_book set shujukuscore=#{shujukuscore} where studentId=#{studentId}")
	int passShujuku(@Param("studentId") int studentId,@Param("shujukuscore") String shujukuscore);
	
	int failOpening(int studentId);
	
	int passKeXingXing(int studentId);
	
	int failKeXingXing(int studentId);
	
	int passXuQiu(int studentId);
	
	int failXuQiu(int studentId);
	
	int passGaiYao(int studentId);
	
	int failGaiYao(int studentId);
	
	int passShuJuKu(int studentId);
	
	int failShuJuKu(int studentId);


}
