package com.demo.upload.service.impl;

import com.demo.upload.dto.LogRequest;
import com.demo.upload.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorage {

    List<LogRequest> storeFile(MultipartFile file) throws ServiceException;
}
