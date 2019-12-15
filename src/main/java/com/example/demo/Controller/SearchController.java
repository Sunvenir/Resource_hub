package com.example.demo.Controller;

import com.example.demo.entity.Expert;
import com.example.demo.entity.Paper;
import com.example.demo.entity.Patent;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ExpertMapper;
import com.example.demo.mapper.PaperMapper;
import com.example.demo.result.SearchResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SearchController {


    @Resource
    private ExpertMapper expertMapper;

    @Resource
    private PaperMapper paperMapper;


    static String old_searchword;
    static String old_searchkind;
    static List<Expert> old_experts;
    static List<Paper> old_papers;
    static List<Patent> old_patents;
    static List<Project> old_projects;

    @CrossOrigin(origins = "*")
    @RequestMapping("/api/search")
    public SearchResult search(@RequestParam(name = "searchword") String searchword,
                               @RequestParam(name = "searchkind") String searchkind,
                               @RequestParam(name = "pagenum") int pagenum,
                               @RequestParam(name = "expertID") int expertID){
        SearchResult searchResult = new SearchResult();
        if(searchkind == "expert"){
            if(searchkind == old_searchkind && searchword == old_searchword){
                if(old_experts.size() < pagenum * 10){
                    searchResult.setExperts(old_experts.subList(pagenum * 10 - 10,old_experts.size() - 1));
                }
                else
                    searchResult.setExperts(old_experts.subList(pagenum * 10 - 10,pagenum * 10 - 1));
                searchResult.setNum(old_experts.size());
                return searchResult;
            }
            else{
                old_searchword = searchword;
                old_searchkind = searchkind;
                List<Expert> experts = new ArrayList<Expert>();
                experts = expertMapper.searchExpert(searchword);
                old_experts = experts;
                if(experts.size() < pagenum * 10){
                    searchResult.setExperts(experts.subList(pagenum * 10 - 10,experts.size() - 1));
                }
                else
                    searchResult.setExperts(experts.subList(pagenum * 10 - 10,pagenum * 10 - 1));
                searchResult.setNum(experts.size());
                return searchResult;
            }
        }
        else if(searchkind == "paper"){
            if(searchkind == old_searchkind && searchword == old_searchword){
                if(old_papers.size() < pagenum * 10){
                    searchResult.setPapers(old_papers.subList(pagenum * 10 - 10,old_papers.size() - 1));
                }
                else
                    searchResult.setPapers(old_papers.subList(pagenum * 10 - 10,pagenum * 10 - 1));
                searchResult.setNum(old_papers.size());
                return searchResult;
            }
            else{
                old_searchword = searchword;
                old_searchkind = searchkind;
                List<Paper> papers = new ArrayList<Paper>();
                papers = paperMapper.searchPaper(searchword);
                old_papers = papers;
                if(papers.size() < pagenum * 10){
                    searchResult.setPapers(papers.subList(pagenum * 10 - 10,papers.size() - 1));
                }
                else
                    searchResult.setPapers(papers.subList(pagenum * 10 - 10,pagenum * 10 - 1));
                searchResult.setNum(papers.size());
                return searchResult;
            }
        }
        else if(searchkind == "")
}
