package com.itss.cms.service;

import com.itss.cms.dto.CLassRoomRequest;
import com.itss.cms.dto.ClassRoomResponse;
import com.itss.cms.entity.ClassRoomEntity;
import com.itss.cms.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomRepository classRoomRepository;
    public void persistClassRoom(CLassRoomRequest classRoom) {
        ClassRoomEntity classRoomEntity = new ClassRoomEntity();
        classRoomEntity.setClassId(classRoom.getClassId());
        classRoomEntity.setDepartmentId(classRoom.getDepartmentId());
        classRoomEntity.setStudentId(classRoom.getStudentId());
        classRoomEntity.setStaffId(classRoom.getStaffId());
        classRoomEntity.setSection(classRoom.getSection());
        classRoomRepository.save(classRoomEntity);
    }
    public ClassRoomResponse getClassRoomInfo(int studentId){

        ClassRoomEntity classRoomEntity = classRoomRepository.findById(studentId).get();
        ClassRoomResponse classRoomResponse = new ClassRoomResponse();

        classRoomResponse.setClassId(classRoomEntity.getClassId());
        classRoomResponse.setDepartmentId(classRoomEntity.getDepartmentId());
        classRoomResponse.setStudentId(classRoomEntity.getStudentId());
        classRoomResponse.setStaffId(classRoomEntity.getStaffId());
        classRoomResponse.setSection(classRoomEntity.getSection());
        classRoomResponse.setSection(classRoomEntity.getSection());


        return classRoomResponse;
    }

}
