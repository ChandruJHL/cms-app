package com.itss.cms.controller;

import com.itss.cms.dto.StaffRequest;
import com.itss.cms.dto.StaffResponse;
import com.itss.cms.entity.StaffEntity;
import com.itss.cms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StaffController {

    // Staff Details
    @Autowired
    StaffService staffService;

    @PostMapping(path = "/staff", consumes = "application/json")
    public String addStaffInfo(@RequestBody StaffRequest staffInfo) {
        staffService.persistStaffInfo(staffInfo);
        return "Accepted";
    }

    @GetMapping(path = "/staff")
    public StaffResponse getStaffInfo(@RequestParam int staffId) {

        return staffService.getStaffDetail(staffId);
    }
    @GetMapping(path ="/staff/all")
    public ArrayList<StaffResponse> getAllStaffInfo(){
        return staffService.getAllStaffInfo();
    }

    @PutMapping(path ="/staff", consumes ="application/json")
    public StaffEntity updateStaffInfo(@RequestParam int staffId, @RequestBody StaffEntity staffEntity){
        return staffService.updateStaffInfo(staffId,staffEntity);
    }
    @DeleteMapping(path ="/staff")
    public StaffEntity delStaffInfo(@RequestParam int staffId){
        return staffService.delStaffInfo(staffId);
    }

}
