package com.demo.upload.repository;

import com.demo.upload.dto.LogRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogFileRepository extends JpaRepository<LogRequest, String> {


}
