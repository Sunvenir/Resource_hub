package com.example.demo.Controller;


import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.result.DeleteProjectResult;
import com.example.demo.result.GetProjectResult;
import com.example.demo.result.InsertProjectResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProjectController {
        @Resource
        private ProjectMapper ProjectMapper;
        @CrossOrigin(origins = "*")
        @RequestMapping("/api/project")
        public GetProjectResult project(@RequestParam("projectID") String projectID) {
                GetProjectResult getProjectResult = new GetProjectResult();
                if (ProjectMapper.getProject(projectID) != null) {
                        getProjectResult.setProject(ProjectMapper.getProject(projectID));
                }
           return getProjectResult;
        }
        @CrossOrigin(origins = "*")
        @RequestMapping("/api/insertProject")
        public InsertProjectResult insertProject(@RequestParam("expertID") final int expertID,
                                                 @RequestParam(value="projectName",required = false) final String projectName,
                                                 @RequestParam(value="approveUnit",required = false) final String approveUnit,
                                                 @RequestParam(value="brief",required = false) final String brief,
                                                 @RequestParam(value="beginDate",required = false) final String beginDate,
                                                 @RequestParam(value="finishDate",required = false) final String finishDate,
                                                 @RequestParam(value="projectType",required = false) final String projectType){
                InsertProjectResult insertProjectResult=new InsertProjectResult();
                Project project = new Project();
                int projectID= ProjectMapper.searchMax()+1;
                project.setProjectID(projectID);
                project.setProjectName(projectName);
                project.setApproveUnit(approveUnit);
                project.setBrief(brief);
                project.setBeginDate(beginDate);
                project.setFinishDate(finishDate);
                project.setProjectType(projectType);
                ProjectMapper.insertProject(project);
                ProjectMapper.insertRelationship_project(expertID,project.getProjectID());
                insertProjectResult.setProjectID(project.getProjectID());
                return insertProjectResult;
        }
        @CrossOrigin(origins = "*")
        @RequestMapping("/api/deleteProject")
        public DeleteProjectResult deleteProject(@RequestParam("expertID") int expertID,
                                                 @RequestParam("projectID") int projectID){
                int code = 200;
                if(ProjectMapper.getRelationship_project(expertID,projectID)!=null) {
                        ProjectMapper.deleteProject(expertID, projectID);
                        if (ProjectMapper.getRelationship_project(expertID, projectID) == null) {
                                code = 100;
                        }
                }
                DeleteProjectResult deleteProjectResult =new DeleteProjectResult(code);
                return deleteProjectResult;
        }
}