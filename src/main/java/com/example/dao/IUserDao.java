package com.example.dao;


import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @date 2022-4-23
 * @author zhangC
 * 查询用户信息 根据id
 * 查询登陆信息 根据页面给定的 userNo和password
 * 获得用户密码
 * 修改密码
 * 
 *
 */
@Mapper
public interface IUserDao {
	@Select("select * from t_user where id=#{id}")
	User queryById(int id);
	@Select("select * from t_user where userNo=#{userNo} and password=#{password}")
	User login(User user);
	@Select("select * from t_user where userNo=#{userNo}")
	User getPassword(String userNo);
	@Update("update t_user set password = #{password} where userNo=#{userNo}")
	int modifyPassword(@Param("userNo") String userNo, @Param("password") String password);
}
