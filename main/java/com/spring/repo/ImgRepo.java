package com.spring.repo;

import com.spring.entity.StudentImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRepo extends JpaRepository<StudentImages,Integer>
{

}
