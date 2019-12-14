package com.example.demo.result;

import com.example.demo.entity.Expert;

public class ExpertIDResult {
    private Expert expert;

    public ExpertIDResult(Expert expert) {
        this.expert = expert;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

}