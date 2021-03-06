package com.example.demo.mapper;

import com.example.demo.entity.Expert;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ExpertMapper {
    @Insert({
            "insert into Expert(expertID,expertName,institution,brief,technicalField,avatarUrl) values(#{expertID},#{expertName},#{institution},#{brief},#{technicalField},#{avatarUrl})" })
    int insertExpert(Expert expert);

    @Update({
            "update Expert set institution=#{institution},brief=#{brief},technicalField=#{technicalField} where expertID=#{expertID}" })
    int editExpert(Expert expert);

    @Select("select * from Expert where expertID=#{expertID}")
    Expert getExpertByID(int ID);

    @Select("select * from Expert where institution not like '%医%' order by paperNum desc limit 5")
    Expert[] expertRecommend();

    @Update("update Expert set ifidentification=1 where expertID=#{expertID}")
    int idenExpert(Expert expert);

    @Update("update Expert set paperNum=paperNum+1 where expertID=#{expertID}")
    int addPaper(int ID);

    @Select("select * from Expert where (institution like #{searchworda} or expertName like #{searchworda} or technicalField like #{searchworda}) " +
            "and (institution like #{searchwordb} or expertName like #{searchwordb} or technicalField like #{searchwordb})" +
            "and (institution like #{searchwordc} or expertName like #{searchwordc} or technicalField like #{searchwordc})")
    List<Expert> searchExpert1(String searchworda,String searchwordb,String searchwordc);

    @Select("select * from Expert where expertID=#{expertID}")
    List<Expert> searchExpert2(int expertID,String searchword);
}
