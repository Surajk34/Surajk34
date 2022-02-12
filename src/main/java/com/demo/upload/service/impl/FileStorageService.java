package com.demo.upload.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.demo.upload.dto.FileRequest;
import com.demo.upload.dto.LogRequest;
import com.demo.upload.exception.ServiceException;
import com.demo.upload.repository.LogFileRepository;
import com.demo.upload.service.FileStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements FileStorage {

	private static final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

	@Autowired
	private LogFileRepository logFileRepository;

	@Override
	public List<LogRequest> storeFile(MultipartFile multipartFile) throws ServiceException {

		FileRequest fileRequestDTO = getFileRequestDTO(multipartFile);
		logger.debug("File Request log size {}", fileRequestDTO.getLogRequestList().size());
		List<LogRequest> logRequestList = fileRequestDTO.getLogRequestList();

		logRequestList.stream().forEach(logRequest -> logFileRepository.save(logRequest));
		return logFileRepository.findAll();
	}

	public FileRequest getFileRequestDTO(MultipartFile multipartFile) throws ServiceException {
		try {
			String fileRequestString = new String(multipartFile.getBytes());
			if (Objects.isNull(fileRequestString)) {
				throw new ServiceException("Invalid file.");
			}
			return getObjectFromJSONString(fileRequestString, FileRequest.class);
		} catch(IOException ioException) {
			throw new ServiceException(ioException.getMessage());
		}
	}

	public static <T> T getObjectFromJSONString(final String string, final Class<T> classType) throws ServiceException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(string, classType);
		} catch (IOException ioException) {
			throw new ServiceException(ioException.getMessage());
		}
	}
}