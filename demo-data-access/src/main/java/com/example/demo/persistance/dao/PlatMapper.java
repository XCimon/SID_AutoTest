package com.example.demo.persistance.dao;

import com.example.demo.persistance.model.Plat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Cirmons
 * @Date: 2021-10-09
 */
@Mapper
public interface PlatMapper{

    @Select("select * from plat where uuid = #{id}")
    Plat getAllRecord(@Param("id") String id);

}
