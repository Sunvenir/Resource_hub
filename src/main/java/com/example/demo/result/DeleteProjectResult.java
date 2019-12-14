package com.example.demo.result;

import com.example.demo.entity.Project;

public class DeleteProjectResult {
    private int code;
    public DeleteProjectResult(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}