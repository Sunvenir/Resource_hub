package com.example.demo.mapper;

import com.example.demo.entity.Expert;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ExpertMapper {
    @Insert({
            "insert into Expert(ID,expertName,institution,brief,field,avatarUrl) values(#{expertID},#{expertName},#{institution},#{brief},#{technicalField},#{avatarUrl})" })
    int insertExpert(Expert expert);

    @Update({
            "update Expert set institution=#{institution},brief=#{brief},field=#{technicalField} where ID=#{expertID}" })
    int editExpert(Expert expert);

    @Select("select * from Expert where ID=#{expertID}")
    Expert getExpertByID(int ID);

    @Select("select * from Expert order by paperNum desc limit 5")
    Expert[] expertRecommend();

<<<<<<< HEAD
        @Select("select * from Expert order by paperNum desc limit 5")
        Expert[] expertRecommend();

        @Update("update Expert set paperNum=paperNum+1 where expertID=#{expertID}")
        int addPaper(int expertID);
=======
    @Update("update Expert set paperNum=paperNum+1 where ID=#{expertID}")
    int addPaper(int ID);

    @Select("select * from Expert where institution like #{searchword} or expertName like #{searchword} " +
            "or field like #{searchword}")
    List<Expert> searchExpert(String searchword);
>>>>>>> b1b590d373591598e86f66da50ed72de3bf44113
}
