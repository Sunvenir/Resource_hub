package com.example.demo.result;

import com.example.demo.entity.Paper;

public class PaperSearchResult {
    private Paper paper;
    public PaperSearchResult(Paper p)
    {
        this.paper = p;
    }
    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
