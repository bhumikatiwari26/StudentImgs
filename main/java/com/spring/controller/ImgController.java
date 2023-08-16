package com.spring.controller;

import com.spring.entity.StudentImages;
import com.spring.service.ImgService;
import jakarta.servlet.annotation.MultipartConfig;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ImgController
{
@Autowired
    private ImgService imgService;
@PostMapping("/save")
    public String saveStudentImg( @RequestParam MultipartFile studentImg,@RequestParam Integer studentId, @RequestParam  String studentName , @RequestParam String studentAddress){
    StudentImages studentImg1 = imgService.saveStudentImg(studentImg,studentId,studentName,studentAddress);
    String message = null;
    if(studentImg1!=null){
        message="data is saved successfully";
    }
    else{
        message = "data is not saved";
    }
    return  message;
}
@DeleteMapping("/delete/{studentId}")
    public void deletestudentImg(@PathVariable Integer studentId){
    imgService.deleteStudentImg(studentId);
}
@GetMapping("/getAll")
    public List<StudentImages> getAllstudentImg()
{
 List   <StudentImages>  s = imgService.getAllStudentImg();
 return  s;
}
@GetMapping("/get/{studentId}")
    public StudentImages getStudentImg(@PathVariable Integer studentId)
{
    StudentImages s11= imgService.getStudentImg(studentId);
    return s11;
}
@PutMapping("/update/{studentId}")
    public  StudentImages updateStudentImages(   @RequestParam  MultipartFile studentImg,@RequestParam Integer studentId, @RequestParam  String studentName , @RequestParam String studentAddress)
{
    StudentImages studentImages =imgService.updateStudentImg(studentImg,studentId,studentName,studentAddress);

 return studentImages  ;
}

}
