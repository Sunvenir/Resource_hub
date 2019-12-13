package com.example.demo.result;

import com.example.demo.entity.Expert;

public class ExpertRecommendResult {
    private Expert[] experts;

    public ExpertRecommendResult(Expert[] experts) {
        this.experts = experts;
    }

    public Expert[] getExperts() {
        return experts;
    }

    public void setExperts(Expert[] experts) {
        this.experts = experts;
    }

}