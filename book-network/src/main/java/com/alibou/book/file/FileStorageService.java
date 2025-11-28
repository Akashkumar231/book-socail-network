package com.alibou.book.file;

import com.alibou.book.book.Book;
import jakarta.mail.Multipart;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

import static java.io.File.separator;

@Service
public class FileStorageService {


    @Value("${application.file.upload.photos-output-path}")
    private  String fileUploadPath;

    public String saveFile(
            @NonNull Multipart sourceFile,
            @NonNull Book book,
            @NonNull Integer userId) {
        final String fileUploadSubPath ="users" + separator + userId;
        return uploadFile(sourceFile,fileUploadSubPath);
    }

    private String uploadFile(@NonNull Multipart sourceFile,
                              @NonNull String fileUploadSubPath) {
        final String finalUploadPath = fileUploadPath + separator + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);
        if (!)
    }

    private String uploadFile
}
