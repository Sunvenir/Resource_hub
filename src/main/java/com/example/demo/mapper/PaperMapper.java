package com.example.demo.mapper;

import com.example.demo.entity.Paper;
import com.example.demo.entity.Paper_Expert;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PaperMapper{
    @Select("select * from paper where paperID=#{paperID}")
    Paper search(int paperID);

    @Insert({"insert into paper(paperID,paperName,date,source,keywords,paperType,"+
             "abstract,author) values (#{paperID},#{paperName},#{date},#{source},"+
             "#{keywords},#{paperType},#{abstractStr},#{author})"})
    int insertPaper(Paper p);

    @Insert({"insert into paper_expert(expertID, paperID) values (#{expertID},#{paperID})"})
    int insertPaper_expert(Paper_Expert pe);
    @Delete({"delete from paper_expert where expertID = #{expertID} and paperID = #{paperID}"})
    int delete(int expertID, int paperID);


}