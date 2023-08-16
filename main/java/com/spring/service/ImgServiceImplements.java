package com.spring.service;

import com.spring.entity.StudentImages;
import com.spring.repo.ImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ImgServiceImplements implements ImgService
{
   @Autowired
    private ImgRepo imgRepo;


    @Override
    public StudentImages saveStudentImg(MultipartFile studentImg, Integer studentId, String studentName, String studentAddress)
    {
      StudentImages studentImg1 = new StudentImages();

        try {
            studentImg1.setStudentImg(Base64.getEncoder().encodeToString(studentImg.getBytes()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        studentImg1.setStudentId(studentId);
        studentImg1.setStudentName(studentName);
        studentImg1.setStudentAddress(studentAddress);
        imgRepo.save(studentImg1);
        return studentImg1;
    }

    @Override
    public void deleteStudentImg(Integer studentId)
    {
        imgRepo.deleteById(studentId);
    }

    @Override
    public List<StudentImages> getAllStudentImg()
    {
        List<StudentImages> s2 = imgRepo.findAll();
        return s2;
    }

    @Override
    public StudentImages getStudentImg(Integer studentId)
    {
        StudentImages s3 = imgRepo.findById(studentId).get();
        return s3;
    }

    @Override
    public StudentImages updateStudentImg(MultipartFile studentImg, Integer studentId, String studentName, String studentAddress)
    {
        StudentImages s1 =imgRepo.findById( studentId).get();

        s1.setStudentId(studentId);
        s1.setStudentName(studentName);
        s1.setStudentAddress(studentAddress);
        try{
            s1.setStudentImg(Base64.getEncoder().encodeToString(studentImg.getBytes()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return  imgRepo.save(s1);
    }


}
