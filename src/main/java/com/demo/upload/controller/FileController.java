package com.demo.upload.controller;

import com.demo.upload.dto.LogRequest;
import com.demo.upload.exception.ServiceException;
import com.demo.upload.service.impl.FileStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.upload.service.impl.FileStorageService;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileStorage fileStorage;

	@PostMapping("/fileupload")
	public ResponseEntity<List<LogRequest>> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws ServiceException {

		logger.debug("filename {}",multipartFile.getName());
		List<LogRequest> logRequestList = fileStorage.storeFile(multipartFile);

		return new ResponseEntity<List<LogRequest>>(logRequestList, HttpStatus.ACCEPTED);
	}

}