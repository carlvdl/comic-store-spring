package com.example.comicstorespring.controller;

import com.example.comicstorespring.model.AdminUser;
import com.example.comicstorespring.model.AdminUserFile;
import com.example.comicstorespring.model.UploadFileResponse;
import com.example.comicstorespring.service.AdminUserFileService;
import com.example.comicstorespring.service.AdminUserService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

//https://www.callicoder.com/spring-boot-file-upload-download-jpa-hibernate-mysql-database-example/
//https://dzone.com/articles/upload-and-retrieve-filesimages-using-spring-boot

@CrossOrigin
@RestController
public class AdminUserFileController {

    private AdminUserFileService adminUserFileService;
    private AdminUserService adminUserService;

    AdminUserFileController(AdminUserFileService adminUserFileService, AdminUserService adminUserService) {
        this.adminUserFileService = adminUserFileService;
        this.adminUserService = adminUserService;
    }

    @PostMapping("/adminUser/{adminUserId}/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long adminUserId) {

        System.out.println("---");
        System.out.println(file);
        System.out.println("--2-");
        AdminUser adminUser  = adminUserService.findById(adminUserId);
        System.out.println("-3--");

        AdminUserFile adminUserFile = adminUserFileService.storeFile(file, adminUser);
        System.out.println("--4-");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(adminUserFile.getId().toString())
                .toUriString();
        System.out.println("--5-");

        return new UploadFileResponse(adminUserFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, null))
                .collect(Collectors.toList());
    }

    //http://localhost:8080/adminUser/8/downloadFile/15
    @GetMapping("/adminUser/{adminUserId}/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {

        //XX TODO
        //DO a check to see if adminUser/8 has access to file 15

        // Load file from database
        AdminUserFile dbFile = adminUserFileService.getFile(fileId);
        System.out.println("dbFile:");
        System.out.println(dbFile);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
}
