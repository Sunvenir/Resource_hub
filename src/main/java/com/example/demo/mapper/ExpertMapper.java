package com.example.demo.mapper;

import com.example.demo.entity.Expert;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ExpertMapper {
    @Insert({
            "insert into Expert(ID,expertName,institution,brief,field,avatarUrl) values(#{ID},#{expertName},#{institution},#{brief},#{field},#{avatarUrl})" })
    int insertExpert(Expert expert);

    @Update({ "update Expert set institution=#{institution},brief=#{brief},field=#{field} where ID=#{ID}" })
    int editExpert(Expert expert);

    @Select("select * from Expert where ID=#{ID}")
    Expert getExpertByID(int ID);

    // TODO: select experts who have the most achievements
    @Select("select * from Expert limit 5")
    Expert[] expertRecommend();

    @Update("update Expert set paperNum=paperNum+1 where ID=#{ID}")
    int addPaper(int ID);
}
