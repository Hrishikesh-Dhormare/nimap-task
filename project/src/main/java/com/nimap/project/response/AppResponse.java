package com.nimap.project.response;

public class AppResponse {

    private String message;
    private boolean status;

    public AppResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public AppResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
