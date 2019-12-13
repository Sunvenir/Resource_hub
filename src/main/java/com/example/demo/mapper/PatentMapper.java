package com.example.demo.mapper;

import com.example.demo.entity.Patent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PatentMapper {
    @Select("select * from patent where patentID=#{patentID}")
    Patent search(int patentID);

    @Insert({"insert into patent(expertID,patentName,applicationDate,authorizationDate," +
            "patentNumber,brief,patentType,patentAuthor) values(#{expertID},#{patentName}," +
            "#{applicationDate}, #{authorizationDate},#{patentNumber},#{brief},#{patentType}, #{patentAuthor})"})
    int insert(Patent p);

    @Delete({"delete from patent_expert where expertID = #{expertID} and patentID = #{patentID}"})
    int delete(int expertID, int patentID);
}
