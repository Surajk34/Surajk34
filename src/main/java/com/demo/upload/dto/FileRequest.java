package com.demo.upload.dto;

import java.util.List;

public class FileRequest {

    List<LogRequest> logRequestList;

    public FileRequest() {}

    public FileRequest(String logRequest) {}

    public List<LogRequest> getLogRequestList() {
        return logRequestList;
    }

    public void setLogRequestList(List<LogRequest> logRequestList) {
        this.logRequestList = logRequestList;
    }
}
