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

    @Select("select max(patentID) from patent ")
    int searchmax();

    @Insert({"insert into patent(patentID,patentName,applicationDate,authorizationDate," +
            "patentNumber,brief,patentType,patentAuthor) values(#{patentID},#{patentName}," +
            "#{applicationDate}, #{authorizationDate},#{patentNumber},#{brief},#{patentType}, #{patentAuthor})"})
    int insertPatent(Patent p);

    @Insert({"insert into patent_expert(expertID, patentID) values(#{expertID},#{patentID})"})
    int insertPatent_expert(Patent_Expert pe);

    @Delete({"delete from patent_expert where expertID = #{expertID} and patentID = #{patentID}"})
    int delete(int expertID, int patentID);

    @Select("select * from patent where (patentName like #{searchworda} and  patentName like #{searchwordb} and patentName like #{searchwordc}) or (brief like #{searchworda} and brief like #{searchworda} and brief like #{searchworda})")
    List<Patent> searchPatent1(String searchworda,String searchwordb,String searchwordc);

    @Select("SELECT * FROM patent join patent_expert where patent.patentID = patent_expert.patentID and patent_expert.expertID = #{expertID} and ((patentName like #{searchworda} and  patentName like #{searchwordb} and patentName like #{searchwordc}) or (brief like #{searchworda} and brief like #{searchworda} and brief like #{searchworda}))")
    List<Patent> searchPatent2(int expertID,String searchword);
}
