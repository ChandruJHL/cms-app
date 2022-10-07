package com.itss.cms.service;

import com.itss.cms.dto.StudentRequest;
import com.itss.cms.dto.StudentResponse;
import com.itss.cms.entity.StudentEntity;
import com.itss.cms.repository.StudentRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public void addStudent(@NotNull StudentRequest studentInfo) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(studentInfo.getId());
        studentEntity.setStudentName(studentInfo.getName());
        studentEntity.setStudentAge(studentInfo.getAge());
        studentRepository.save(studentEntity);

    }

    public StudentResponse getStudentInfo(int studentId) {

        StudentEntity studentEntity = studentRepository.findById(studentId).get();
        StudentResponse studentResponse  = new StudentResponse();
        studentResponse.setStudentAge(studentEntity.getStudentAge());
        studentResponse.setStudentName(studentEntity.getStudentName());
        return  studentResponse;
    }

    public StudentEntity updatedStudentInfo(int studentId, StudentEntity updatedStudentInfo) {

        StudentEntity existingStudentInfo;
        existingStudentInfo = studentRepository.findById(studentId).get();
        if (existingStudentInfo == null) {
            System.out.println("user id is invalid");
        } else {
            existingStudentInfo.setStudentName(updatedStudentInfo.getStudentName());
            existingStudentInfo.setStudentAge(updatedStudentInfo.getStudentAge());
            studentRepository.save(existingStudentInfo);
        }
        return existingStudentInfo;
    }
    public StudentEntity deleteStudentInfo(int studentId) {

        StudentEntity existingStudentInfo = studentRepository.findById(studentId).get();
        if (existingStudentInfo == null) {
            System.out.println("user id is invalid");
        } else {
            studentRepository.delete(existingStudentInfo);
        }
        return existingStudentInfo;
    }

    @PostConstruct
    public ArrayList<StudentResponse> getAllStudentsInfo() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(" student Details ");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1",new Object[]{"ID", "NAME", "AGE"});
        ArrayList<StudentEntity> studentsInfo = (ArrayList<StudentEntity>) studentRepository.findAll();
        ArrayList<StudentResponse> studentResponses = new ArrayList<>();
        for (int i = 0; i < studentsInfo.size(); i++) {

            StudentEntity studentEntity = studentsInfo.get(i);
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setStudentName(studentEntity.getStudentName());
            studentResponse.setStudentAge(studentEntity.getStudentAge());
            studentResponses.add(studentResponse);
            data.put(studentEntity.getStudentId(), new Object[]{studentEntity.getStudentId(), studentEntity.getStudentName(), studentEntity.getStudentAge()});
        }
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            // Creating a new row in the sheet
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                // This line creates a cell in the next
                //  column of that row
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }

        }
        try {
            // Writing the workbook
            FileOutputStream out = new FileOutputStream(new File("D:\\JAVA\\Student123.xlsx"));
            workbook.write(out);
            // Closing file output connections
            out.close();
            // Console message for successful execution of
            // program
            System.out.println("student.xlsx written successfully on disk.");
        }
        // Catch block to handle exceptions
        catch (Exception e) {
            // Display exceptions along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return studentResponses;
    }
}
