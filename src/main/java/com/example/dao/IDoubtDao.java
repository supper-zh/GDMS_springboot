package com.example.dao;


import com.example.entity.Doubt;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangh
 * 添加学生提出的疑惑
 * 显示某一学生的所有疑惑
 * 更新疑惑信息
 *
 */
@Mapper
public interface IDoubtDao {

	@Insert("insert into t_doubt values(null,#{studentId},#{studentDoubt},#{answer})")
	int addDoubt(@Param("doubt") Doubt doubt);
	@Select("select * from t_doubt where studentId=#{studentId}")
	List<Doubt> getAllDoubt(@Param("studentId") int studentId);
	@Update("update t_doubt set answer=#{answer} where id=#{id}")
	int updateDoubt(@Param("doubt") Doubt doubt);
	
	
}
