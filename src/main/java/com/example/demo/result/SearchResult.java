package com.example.demo.result;

import com.example.demo.entity.Expert;
import com.example.demo.entity.Paper;
import com.example.demo.entity.Patent;
import com.example.demo.entity.Project;

import java.util.List;

public class SearchResult {
    private List<Expert> experts;
    private List<Paper> papers;
    private List<Patent> patents;
    private List<Project> projects;

    public List<Expert> getExperts() {
        return experts;
    }

    public void setExperts(List<Expert> experts) {
        this.experts = experts;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }

    public List<Patent> getPatents() {
        return patents;
    }

    public void setPatents(List<Patent> patents) {
        this.patents = patents;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
