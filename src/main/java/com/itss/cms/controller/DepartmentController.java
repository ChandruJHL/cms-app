package com.itss.cms.controller;

import com.itss.cms.dto.DepartmentRequest;
import com.itss.cms.dto.DepartmentResponse;
import com.itss.cms.entity.DepartmentEntity;
import com.itss.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    // Department record
    @Autowired
    DepartmentService departmentService;
    @PostMapping(path = "/department", consumes = "application/json" ,produces = "application/json" )
    public String createNewDepartment(@RequestBody DepartmentRequest department)
    {
        departmentService.persistDepartment(department);
        return "Accepted";
    }

    @GetMapping(path = "/department",produces = "application/json")
    public DepartmentResponse getDepartmentInfo(@RequestParam String departmentId)
    {
        return departmentService.getDepartmentInfo(departmentId);

    }

    @PutMapping(path = "/department",consumes = "application/json")
    public DepartmentEntity updateDepartment(@RequestParam String deptId, @RequestBody DepartmentEntity deptEntity)
    {
        return departmentService.updateDepartInfo(deptId,deptEntity);
    }
    @DeleteMapping(path="/department")
    public  DepartmentEntity delDepartment(@RequestParam String departmentId)
   {
        return departmentService.delDepartment(departmentId);
   }

}
