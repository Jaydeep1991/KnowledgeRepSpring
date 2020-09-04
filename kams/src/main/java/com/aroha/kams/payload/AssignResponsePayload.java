package com.aroha.kams.payload;

public class AssignResponsePayload {
    private String msg;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AssignResponsePayload(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }

    public AssignResponsePayload() {
    }
}
