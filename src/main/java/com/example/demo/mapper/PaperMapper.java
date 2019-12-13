package com.example.demo.mapper;

import com.example.demo.entity.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PaperMapper{
    @Select("select * form paper where paperID=#{paperID}")
    Paper search(int paperID);

    @Insert({"insert into paper(expertID,paperName,date,source,keywords,paperType,"+
             "abstract,author) values (#{expertID},#{paperName},#{date},#{source},"+
             "#{keywords},#{paperType},#{abstract},#{author})"})
    int insert(Paper p);

    @Delete({"delete from paper_expert where expertID = #{expertID} and paperID = #{paperID}"})
    int delete(int expertID, int paperID);


}