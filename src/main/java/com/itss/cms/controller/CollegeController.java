package com.itss.cms.controller;
import com.itss.cms.dto.CollegeRequest;
import com.itss.cms.dto.CollegeResponse;
import com.itss.cms.entity.CollegeEntity;
import com.itss.cms.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollegeController {

    // College Records
    @Autowired
    CollegeService collegeService;

    @PostMapping(path = "/college", consumes = "application/json")
    public String addNewCollege(@RequestBody CollegeRequest college) {
        collegeService.persistCollege(college);
        return "Accepted";
    }

    @GetMapping(path = "/college")
    public CollegeResponse getCollege(@RequestParam int contactNumber) {
        return collegeService.getCollegeInfo(contactNumber);
    }


}
