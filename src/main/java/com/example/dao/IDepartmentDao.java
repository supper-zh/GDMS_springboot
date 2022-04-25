package com.example.dao;


import com.example.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangh
 * 查询全部的院系
 * id ==> name
 * name ==> id
 * 
 */
@Mapper
public interface IDepartmentDao {

	@Select("select * from t_department")
	List<Department> allDepartment();
	@Select("select departmentName from t_department where id=#{id}")
	String getNameById(@Param("id") int id);
	@Select("select id from t_department where departmentName=#{departmentName}")
	int getIdByName(@Param("name") String name);
}
