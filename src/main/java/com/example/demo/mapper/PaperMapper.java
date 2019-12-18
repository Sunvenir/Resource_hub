package com.example.demo.mapper;

import com.example.demo.entity.Paper;
import com.example.demo.entity.Paper_Expert;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PaperMapper{
    @Select("select * from paper where paperID=#{paperID}")
    Paper search(int paperID);

    @Select("select max(paperID) from paper")
    int searchPaperMaxId();

    @Insert({"insert into paper(paperID,paperName,date,source,keywords,paperType,"+
             "abstract,author) values (#{paperID},#{paperName},#{date},#{source},"+
             "#{keywords},#{paperType},#{_abstract},#{author})"})
    int insertPaper(Paper p);

    @Insert({"insert into paper_expert(expertID, paperID) values (#{expertID},#{paperID})"})
    int insertPaper_expert(Paper_Expert pe);

    @Delete({"delete from paper_expert where expertID = #{expertID} and paperID = #{paperID}"})
    int delete(int expertID, int paperID);

    @Select("select * from paper where(paperName like #{searchworda} and paperName like #{searchwordb} and paperName like #{searchwordc})" +
            "or (author like #{searchworda} and author like #{searchwordb} and author like #{searchwordc})" +
            "or (abstract like #{searchworda} and abstract like #{searchwordb} and abstract like #{searchwordc})" +
            "or (keywords like #{searchworda} and keywords like #{searchwordb} and keywords like #{searchwordc})")
    List<Paper> searchPaper1(String searchworda,String searchwordb,String searchwordc);

    @Select("SELECT * FROM paper join paper_expert where paper.paperID = paper_expert.paperID and paper_expert.expertID = #{expertID}")
    List<Paper> searchPaper2(int expertID,String searchword);

}