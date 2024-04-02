package com.propertymarket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

/**
 * @desc used to perform file operation
 */
@Service
public class FileService {

    //    @Value("fileUploadDirectory")
    String fileUploadDirectory = "/home/shuvo/Desktop/code/java/PropertyMarket/src/main/resources/static/uploads";

    public String saveFileToDisk(MultipartFile file) throws IOException {
        byte[] newFileBytes = file.getInputStream().readAllBytes();
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        String filePath = getFileUploadDirectory() + "/" + fileName;

        Path newFilePath = Files.createFile(Path.of(filePath));
        File newFile = new File(newFilePath.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        fileOutputStream.write(newFileBytes);
        fileOutputStream.flush();
        fileOutputStream.close();

        return fileName;
    }


    public String getFileUploadDirectory() {
        Path path = Paths.get("src");
        String uploadsDirectory = path
                                    .getFileName()
                                    .toFile()
                                    .getAbsolutePath();

        uploadsDirectory += "/main/resources/static/uploads";
        return uploadsDirectory;
    }
}
