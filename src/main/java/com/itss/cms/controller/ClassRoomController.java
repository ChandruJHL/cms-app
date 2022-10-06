package com.itss.cms.controller;

import com.itss.cms.dto.CLassRoomRequest;
import com.itss.cms.dto.ClassRoomResponse;
import com.itss.cms.entity.ClassRoomEntity;
import com.itss.cms.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassRoomController {

    //ClassRoom Details
    @Autowired
    ClassRoomService classRoomService;

    @PostMapping(path = "/classRoom", consumes = "application/json")
    public String updateClassRoom(@RequestBody CLassRoomRequest classRoom) {
        classRoomService.persistClassRoom(classRoom);
        return "Accepted";
    }

    @GetMapping(path = "/classRoom")
    public ClassRoomResponse getClassRoom(@RequestParam int studentId) {
        return classRoomService.getClassRoomInfo(studentId);
    }

}
