package com.example.comicstorespring.service;

import com.example.comicstorespring.dao.AdminUserFileRepository;
import com.example.comicstorespring.dao.AdminUserRepository;
import com.example.comicstorespring.exception.FileStorageException;
import com.example.comicstorespring.exception.MyFileNotFoundException;
import com.example.comicstorespring.model.AdminUser;
import com.example.comicstorespring.model.AdminUserFile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AdminUserFileService {

    private AdminUserFileRepository adminUserFileRepository;

    AdminUserFileService(AdminUserFileRepository adminUserFileRepository) {
        this.adminUserFileRepository = adminUserFileRepository;
    }

    public AdminUserFile storeFile(MultipartFile file, AdminUser adminUser) {

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            AdminUserFile dbFile = new AdminUserFile(fileName, file.getContentType(), file.getBytes(), adminUser);

            return adminUserFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    public AdminUserFile getFile(Long fileId) {
        return adminUserFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }


}
