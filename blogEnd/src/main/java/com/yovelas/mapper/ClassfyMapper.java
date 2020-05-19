package com.yovelas.mapper;

import com.yovelas.entity.Article;
import com.yovelas.entity.Classfy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassfyMapper {
    @Select("select * from classfy")
    @Results({
            @Result(property = "id",column = "classfy_id"),
            @Result(property = "name",column = "classfy_name")
    })
    List<Classfy> selectAllClassfy();

    @Select("select * from classfy where classfy_name like concat('%',#{name},'%')")
    @Results({
            @Result(property = "id",column = "classfy_id"),
            @Result(property = "name",column = "classfy_name")
    })
    List<Classfy> selectSpecifyClassfy(
            @Param("name") String name
    );

    @Select("select * from classfy where classfy_id = #{id}")
    @Results({
            @Result(property = "id",column = "classfy_id"),
            @Result(property = "name",column = "classfy_name")
    })
    Classfy selectSpecifyIdClassfy(
            @Param("id") int id
    );

    @Insert("insert into classfy values(null,#{name})")
    int insertClassfy(@Param("name") String name);
}
