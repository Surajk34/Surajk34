package com.demo.upload;

import com.demo.upload.exception.ServiceException;
import com.demo.upload.service.FileStorage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.io.InputStream;

@AutoConfigureMockMvc
public class FileControllerTests {

    private FileStorage fileStorage = Mockito.mock(FileStorage.class);

    @Test
    public void testUploadFile() throws ServiceException, IOException {
        final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("logfile.txt");
        final MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "logfile.txt", "application/json", inputStream);

        fileStorage.storeFile(mockMultipartFile);

    }
}
