package com.spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "studentimg_tab")
public class StudentImages
{
    @Id
    private int studentId;
    private String studentName;
    private String studentAddress;
    @Lob
    @Column(length = 999999999)
    private String studentImg;
}
