package com.example.demo.mapper;

import com.example.demo.entity.Expert;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ExpertMapper {
        @Insert({ "insert into Expert(expertID,expertName,institution,brief,technicalField,avatarUrl) values(#{expertID},#{expertName},#{institution},#{brief},#{technicalField},#{avatarUrl})" })
        int insertExpert(Expert expert);

        @Update({ "update Expert set institution=#{institution},brief=#{brief},technicalField=#{technicalField} where expertID=#{expertID}" })
        int editExpert(Expert expert);

        @Select("select * from Expert where expertID=#{expertID}")
        Expert getExpertByID(int expertID);

        @Select("select * from Expert order by paperNum desc limit 5")
        Expert[] expertRecommend();

        @Update("update Expert set paperNum=paperNum+1 where expertID=#{expertID}")
        int addPaper(int expertID);

        @Select("select * from Expert where institution like #{searchword} or expertName like #{searchword} "
                        + "or field like #{searchword}")
        List<Expert> searchExpert(String searchword);
}
