package com.example.dao;

import com.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class IStudentDaoTest {

    @Autowired
    private IStudentDao iStudentDao;
    @Test
    void selectStudent() {
        Student student = iStudentDao.selectStudent(9);
        System.out.println(student);
    }
}