package com.example.dao;

import com.example.entity.Major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangh
 * 查询全部的专业；
 * id ==> name
 * name ==> id
 * 根据name获得id
 * 
 */
@Mapper
public interface IMajorDao {
	@Select("select * from t_major")
	List<Major> getAllMajor();
	@Select("select majorName from t_major where id=#{id}")
	String getNameByID(@Param("id") int id);
	@Select("select id from t_major where majorName=#{majorName}")
	int getIdByName(@Param("name") String name);
	
	
}
