package com.itss.cms.controller;

import com.itss.cms.dto.HostelRequest;
import com.itss.cms.dto.HostelResponse;
import com.itss.cms.entity.HostelEntity;
import com.itss.cms.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HostelController {
    // Hostel records
    @Autowired
    HostelService hostelService;

    @PostMapping(path = "/hostel", consumes = "application/json")
    public String StudentRecHostel(@RequestBody HostelRequest studentInfo) {
        hostelService.persistHostel(studentInfo);
        return "Accepted";
    }

    @GetMapping(path = "/hostel")
    public HostelResponse getHostelStudentInfo(@RequestParam int studentId) {
        return hostelService.getHostelStudentInfo(studentId);
    }

    @PutMapping(path ="/hostel",consumes = "application/json")
    public HostelEntity updateHostelInfo(@RequestParam int id , @RequestBody HostelEntity hostelInfo)
    {
        return hostelService.updateHostelInfo(id,hostelInfo);
    }

    @DeleteMapping(path="/hostel")
    public HostelEntity delHostelInfo(@RequestParam int id) {
        return hostelService.delHostelInfo(id);
    }

}
