package com.itss.cms.service;
import com.itss.cms.dto.DepartmentRequest;
import com.itss.cms.dto.StudentRequest;
import com.itss.cms.dto.DepartmentResponse;
import com.itss.cms.dto.StudentResponse;
import com.itss.cms.entity.DepartmentEntity;
import com.itss.cms.entity.StudentEntity;
import com.itss.cms.entity.HostelEntity;
import com.itss.cms.repository.DepartmentRepository;
import com.itss.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public void persistDepartment(DepartmentRequest departmentRequest) {

        List<StudentRequest> studentsRequest = departmentRequest.getStudents();
        List<StudentEntity> studentEntities = new ArrayList<>();
        DepartmentEntity departmentEntity = new DepartmentEntity();
        for (int i =0; i < studentsRequest.size(); i++) {

            StudentRequest student = studentsRequest.get(i);
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setStudentName(student.getName());
            studentEntity.setStudentId(student.getId());
            studentEntity.setStudentAge(student.getAge());
            studentEntity.setDepartment(departmentEntity);
            studentEntities.add(studentEntity);
        }

        departmentEntity.setDepartmentId(departmentRequest.getDepartmentId());
        departmentEntity.setDepartmentName(departmentRequest.getDepartmentName());
        departmentEntity.setStudents(studentEntities);
        departmentRepository.save(departmentEntity);


    /*
     DepartmentEntity departmentEntity = new DepartmentEntity();
     departmentEntity.setDepartmentId(departmentRequest.getDepartmentId());
     departmentEntity.setDepartmentName(departmentRequest.getDepartmentName());
     departmentEntity.setHodName(departmentRequest.getHodName());
     departmentEntity.setTotalStaff(departmentRequest.getTotalStaff());
     departmentEntity.setTotalStudent(departmentRequest.getTotalStudent());
     departmentRepository.save(departmentEntity);
  */

    }

    public DepartmentResponse getDepartmentInfo(String departmentId) {

        /*
        DepartmentResponse departmentResponse = new DepartmentResponse();
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        departmentResponse.setDepartmentId(departmentEntity.getDepartmentId());
        departmentResponse.setDepartmentName(departmentEntity.getDepartmentName());
        departmentResponse.setTotalStaff(departmentEntity.getTotalStaff());
        departmentResponse.setTotalStudent(departmentEntity.getTotalStudent());
        return departmentResponse;
        */
        DepartmentResponse departmentResponse = new DepartmentResponse();
        DepartmentEntity entity = departmentRepository.findById(departmentId).get();
        departmentResponse.setDepartmentId(entity.getDepartmentId());
        departmentResponse.setDepartmentName(entity.getDepartmentName());
        List<StudentEntity> studentEntities = entity.getStudents();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (int i = 0; i < studentEntities.size(); i++) {

            StudentEntity studentEntity = studentEntities.get(i);
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setStudentAge(studentEntity.getStudentAge());
            studentResponse.setStudentName(studentEntity.getStudentName());
            studentResponses.add(studentResponse);
        }

        departmentResponse.setStudents(studentResponses);
        return departmentResponse;
    }

    public DepartmentEntity updateDepartInfo(String deptId,DepartmentEntity departmentEntity){

        DepartmentEntity exitingDepartment ;
        exitingDepartment = departmentRepository.findById(deptId).get();
        if (exitingDepartment == null){
            System.out.println("user id is invalid");
        }else{
            exitingDepartment.setHodName(departmentEntity.getHodName());
            exitingDepartment.setTotalStaff(departmentEntity.getTotalStaff());
            exitingDepartment.setTotalStudent(departmentEntity.getTotalStudent());
        }
        return departmentRepository.save(exitingDepartment);
    }
    public DepartmentEntity delDepartment(String departmentId){
        DepartmentEntity existingDepartment ;
        existingDepartment = departmentRepository.findById(departmentId).get();
        if (existingDepartment == null){
            System.out.println("In valid id ");
        }else {
            departmentRepository.delete(existingDepartment);
        }
        return existingDepartment;
    }

}
