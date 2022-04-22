package com.example;

import com.example.dao.IStudentDao;
import com.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GDMSSpringbootApplicationTests {

    @Autowired
    public IStudentDao iStudentDao;
    @Test
     void contextLoads() {
        Student student = iStudentDao.selectStudent(9);
        System.out.println(student);
    }

}
