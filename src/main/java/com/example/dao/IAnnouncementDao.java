package com.example.dao;

import com.example.entity.Announcement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @date 2022-4-23
 * @author zhangh
 * 添加公告
 * 删除公告
 * 查看公告 按时间最新优先的顺序
 *
 */
@Mapper
@Repository
public interface IAnnouncementDao {
	@Insert("insert into t_announcement values(null,#{context},#{inputMan},#{lastModifyTime})")
	int addAnnouncement(@Param("announcement") Announcement announcement);
	@Delete("delete from t_announcement where id=#{id}")
	int deleteAnnouncement(@Param("id") int id);
	@Delete("select * from t_announcement order by lastModifyTime DESC")
	List<Announcement> showAllAnnouncement();
}
