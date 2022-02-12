package com.demo.upload.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    private int errCode;

    private String errMsg;

    private String errName = "Service Exception";

    private List<String> errorMessages;

    public ServiceException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ServiceException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }


}
