package com.spring.service;

import com.spring.entity.StudentImages;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImgService
{
    public StudentImages saveStudentImg(MultipartFile studentImg, Integer studentId, String studentName, String studentAddress);
  public  List <StudentImages> getAllStudentImg();
   public void deleteStudentImg(Integer studentId);
   public StudentImages getStudentImg(Integer studentId);

   public StudentImages updateStudentImg(MultipartFile studentImg , Integer studentId,String studentName, String studentAddress);

}
