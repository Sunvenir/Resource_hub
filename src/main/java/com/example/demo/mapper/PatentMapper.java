package com.example.demo.mapper;

import com.example.demo.entity.Patent;
import com.example.demo.entity.Patent_Expert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PatentMapper {
    @Select("select * from patent where patentID=#{patentID}")
    Patent search(int patentID);

    @Insert({"insert into patent(patentID,patentName,applicationDate,authorizationDate," +
            "patentNumber,brief,patentType,patentAuthor) values(#{patentID},#{patentName}," +
            "#{applicationDate}, #{authorizationDate},#{patentNumber},#{brief},#{patentType}, #{patentAuthor})"})
    int insertPatent(Patent p);

    @Insert({"insert into patent_expert(expertID, patentID) values(#{expertID},#{patentID})"})
    int insertPatent_expert(Patent_Expert pe);

    @Delete({"delete from patent_expert where expertID = #{expertID} and patentID = #{patentID}"})
    int delete(int expertID, int patentID);

    @Select("select * from patent where patentName like #{searchword} or brief liks #{searchword}")
    List<Patent> searchPatent(String searchword);
}
