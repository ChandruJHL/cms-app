package com.itss.cms.controller;
import com.itss.cms.entity.CanteenEntity;
import com.itss.cms.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CanteenController {
    // Canteen Details
    @Autowired
    CanteenService canteenService;
    @PostMapping(path = "/canteen", consumes = "application/json")
    public String updateCanteenInfo(@RequestBody CanteenEntity canteenInfo) {
        canteenService.persistCanteenInfo(canteenInfo);
        return "Accepted";
    }

    @GetMapping(path = "/canteen")
    public CanteenEntity getCanteenInfo(@RequestParam int inChargeId) {
        return canteenService.getCanteenDetail(inChargeId);
    }

}
