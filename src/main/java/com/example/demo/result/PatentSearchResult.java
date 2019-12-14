package com.example.demo.result;

import com.example.demo.entity.Patent;

public class PatentSearchResult {
    private Patent patent;

    public PatentSearchResult(Patent p)
    {
        this.patent = p;
    }
    public Patent getPatent() {
        return patent;
    }

    public void setPatent(Patent patent) {
        this.patent = patent;
    }

}
