package com.springframework.exceltodatabase.service;

import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(),
         "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
}
