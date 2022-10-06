package com.itss.cms.controller;
import com.itss.cms.dto.StudentRequest;
import com.itss.cms.dto.StudentResponse;
import com.itss.cms.entity.*;
import com.itss.cms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController
{
    //Student record
    @Autowired
    StudentService studentService;

    @PostMapping(path = "/student", consumes = "application/json")
    public String createNewStudent(@RequestBody StudentRequest student)
    {
        studentService.addStudent(student);
        return "Accepted";
    }

    @GetMapping(path = "/student")
    public StudentResponse getStudentInfo(@RequestParam int studentId)
    {
        return studentService.getStudentInfo(studentId);
    }

    @PutMapping(path = "/student" )
    public StudentEntity updateStudentInfo(@RequestParam int id, @RequestBody StudentEntity student)
    {
        return studentService.updatedStudentInfo(id, student);
    }

    @DeleteMapping(path = "/student")
    public StudentEntity deleteStudentInfo(@RequestParam int id)
    {

        return studentService.deleteStudentInfo(id);
    }

    @GetMapping(path = "/student/all")
    public ArrayList<StudentResponse> getAllStudents() {
        return studentService.getAllStudentsInfo();
    }

}