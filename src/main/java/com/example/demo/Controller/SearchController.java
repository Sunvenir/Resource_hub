
package com.example.demo.Controller;

import com.example.demo.entity.Expert;
import com.example.demo.entity.Paper;
import com.example.demo.entity.Patent;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ExpertMapper;
import com.example.demo.mapper.PaperMapper;
import com.example.demo.mapper.PatentMapper;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.result.SearchResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {


    @Resource
    private ExpertMapper expertMapper;

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private PatentMapper patentMapper;

    @Resource
    private ProjectMapper projectMapper;


    static String old_searchword = null;
    static String old_searchkind = null;
    static int old_expertID = 99999999;
    static List<Expert> old_experts;
    static List<Paper> old_papers;
    static List<Patent> old_patents;
    static List<Project> old_projects;

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/search")
    public SearchResult search(@RequestParam(name = "searchword") String searchword,
                               @RequestParam(name = "searchkind") String searchkind,
                               @RequestParam(name = "pagenum") int pagenum,
                               @RequestParam(name = "expertID") int expertID) {
        SearchResult searchResult = new SearchResult();
        if (searchkind.equals("expert")) {
            if (searchkind == old_searchkind && searchword == old_searchword && expertID == old_expertID) {
                if (old_experts.size() < pagenum * 10) {
                    searchResult.setExperts(old_experts.subList(pagenum * 10 - 10, old_experts.size()));
                } else
                    searchResult.setExperts(old_experts.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(old_experts.size());
                return searchResult;
            } else {
                old_searchword = searchword;
                old_searchkind = searchkind;
                old_expertID = expertID;
                List<Expert> experts = new ArrayList<Expert>();
                if(expertID == 0){
                    experts = expertMapper.searchExpert1("%"+searchword+"%");
                }
                else experts = expertMapper.searchExpert2(expertID,"%"+searchword+"%");
                //System.out.println(experts.get(0).getExpertName());
                old_experts = experts;
                if (experts.size() < pagenum * 10) {
                    searchResult.setExperts(experts.subList(pagenum * 10 - 10, Math.max(experts.size(), 0)));
                } else
                    searchResult.setExperts(experts.subList(pagenum * 10 - 10, pagenum * 10));
                //System.out.println(searchResult.getExperts().get(0).getExpertName());
                searchResult.setNum(experts.size());
                return searchResult;
            }
        } else if (searchkind.equals("paper")) {
            if (searchkind == old_searchkind && searchword == old_searchword && expertID == old_expertID) {
                if (old_papers.size() < pagenum * 10) {
                    searchResult.setPapers(old_papers.subList(pagenum * 10 - 10, old_papers.size()));
                } else
                    searchResult.setPapers(old_papers.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(old_papers.size());
                return searchResult;
            } else {
                old_searchword = searchword;
                old_searchkind = searchkind;
                List<Paper> papers = new ArrayList<Paper>();
                if(expertID == 0)
                    papers = paperMapper.searchPaper1("%"+searchword+"%");
                else
                    papers = paperMapper.searchPaper2(expertID,"%"+searchword+"%");
                old_papers = papers;
                if (papers.size() < pagenum * 10) {
                    searchResult.setPapers(papers.subList(pagenum * 10 - 10, papers.size()));
                } else
                    searchResult.setPapers(papers.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(papers.size());
                return searchResult;
            }
        } else if (searchkind.equals("patent")) {
            if (searchkind == old_searchkind && searchword == old_searchword && expertID == old_expertID) {
                if (old_patents.size() < pagenum * 10) {
                    searchResult.setPatents(old_patents.subList(pagenum * 10 - 10, old_patents.size()));
                } else
                    searchResult.setPatents(old_patents.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(old_patents.size());
                return searchResult;
            } else {
                old_searchword = searchword;
                old_searchkind = searchkind;
                List<Patent> patents = new ArrayList<Patent>();
                if(expertID == 0)
                    patents = patentMapper.searchPatent1("%"+searchword+"%");
                else patents = patentMapper.searchPatent2(expertID,"%"+searchword+"%");
                old_patents = patents;
                if (patents.size() < pagenum * 10) {
                    searchResult.setPatents(patents.subList(pagenum * 10 - 10, patents.size()));
                } else
                    searchResult.setPatents(patents.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(patents.size());
                return searchResult;
            }
        } else if (searchkind.equals("project")) {
            if (searchkind == old_searchkind && searchword == old_searchword && expertID == old_expertID) {
                if (old_projects.size() < pagenum * 10) {
                    searchResult.setProjects(old_projects.subList(pagenum * 10 - 10, old_projects.size()));
                } else
                    searchResult.setProjects(old_projects.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(old_projects.size());
                return searchResult;
            } else {
                old_searchword = searchword;
                old_searchkind = searchkind;
                List<Project> projects = new ArrayList<Project>();
                if(expertID == 0)
                    projects = projectMapper.searchProject1("%"+searchword+"%");
                else projects = projectMapper.searchProject2(expertID,"%"+searchword+"%");
                old_projects = projects;
                if (projects.size() < pagenum * 10) {
                    searchResult.setProjects(projects.subList(pagenum * 10 - 10, projects.size()));
                } else
                    searchResult.setProjects(projects.subList(pagenum * 10 - 10, pagenum * 10));
                searchResult.setNum(projects.size());
                return searchResult;
            }
        }
        return searchResult;
    }
}
