package com.example.dao;



import com.example.entity.ThesisPaper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangC
 * 添加最终论文
 * 查询所有论文
 *
 */
@Mapper
@Repository
public interface IThesisPaperDao {
	@Insert("insert into t_thesis_paper values(null,#{studentId},#{paperInfo})")
	int addThesisPaper(ThesisPaper paper);
	@Select("select * from t_thesis_paper")
	List<ThesisPaper> getAllInfo();
	
	
}
