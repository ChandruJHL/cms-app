package com.itss.cms.controller;
import com.itss.cms.entity.BusEntity;
import com.itss.cms.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class BusController {

    // Bus details
    @Autowired
    BusService busService;

    @PostMapping(path = "/bus", consumes = "application/json")
    public String updateBusInfo(@RequestBody BusEntity busInfo) {
        busService.persistBusInfo(busInfo);
        return "Accepted";
    }

    @GetMapping(path = "/bus")
    public BusEntity getBusInfo(@RequestParam int busId) {

        return busService.getBusDetail(busId);
    }

}
