package com.example.demo.result;

public class loginresult {
    private int code;
    private String useroot;
    private int expertID;

    public loginresult(int code, String useroot, int expertID) {
        this.code = code;
        this.useroot = useroot;
        this.expertID = expertID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUseroot() {
        return useroot;
    }

    public void setUseroot(String useroot) {
        this.useroot = useroot;
    }

    public int getExpertID() {
        return expertID;
    }

    public void setExpertID(int expertID) {
        this.expertID = expertID;
    }
}
