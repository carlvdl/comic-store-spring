package com.example.comicstorespring.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin_user_file")
public class AdminUserFile {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "admin_user_file_id")
    private Long id;

    @Size(max = 255)
    @Column(name = "file_name")
    private String fileName;

    @Size(max = 255)
    @Column(name = "file_type")
    private String fileType;

    @Lob
    @Column(name = "data")
    private byte[] data;


    @ManyToOne()
    @JoinColumn(name="admin_user_id", referencedColumnName = "admin_user_id")
    private AdminUser adminUser;

    public AdminUserFile() {

    }

    public AdminUserFile(String fileName, String fileType, byte[] data, AdminUser adminUser ) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.adminUser = adminUser;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }
    // Getters and Setters (Omitted for brevity)
}