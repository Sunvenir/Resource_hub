package com.example.demo.mapper;

import com.example.demo.entity.Project;
import com.example.demo.entity.Relationship_project;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectMapper {
    @Insert("insert into Project(projectID,projectName,approveUnit,brief,beginDate,finishDate, projectType) " +
            "values(#{projectID},#{projectName},#{approveUnit},#{brief},#{beginDate},#{finishDate},#{projectType})" )
    int insertProject(Project project);

    @Insert("insert into Relationship_project(expertID,projectID) values(#{expertID},#{projectID})")
    int insertRelationship_project(int expertID,int projectID);

    @Select("select * from Project where projectID=#{projectID}")
    Project getProject(String projectID);

    @Delete("delete from  Relationship_project where expertID=#{expertID} and projectID=#{projectID}")
    void deleteProject(int expertID,int projectID);

    @Select("select * from Relationship_project where expertID=#{expertID} and projectID=#{projectID}")
    Relationship_project getRelationship_project(int expertID, int projectID);

    @Select("select * from Project where projectName like #{searchword} or brief liks #{searchword} or " +
            "projectType like #{searchword}")
    List<Project> searchProject(String searchword);
}
