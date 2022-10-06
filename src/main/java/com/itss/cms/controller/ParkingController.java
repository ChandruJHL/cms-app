package com.itss.cms.controller;

import com.itss.cms.dto.ParkingRequest;
import com.itss.cms.dto.ParkingResponse;
import com.itss.cms.entity.ParkingEntity;
import com.itss.cms.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ParkingController {
    // parking Details
    @Autowired
    ParkingService parkingService;

    @PostMapping(path = "/parking", consumes = "application/json")
    public String addParkingInfo(@RequestBody ParkingRequest parkingInfo) {
        parkingService.persisParkingInfo(parkingInfo);
        return "Accepted";
    }

    @GetMapping(path = "/parking")
    public ParkingResponse getParkingInfo(@RequestParam int slotId) {

        return parkingService.getParkingDetail(slotId);
    }
    @GetMapping(path ="parking/all")
    public ArrayList<ParkingResponse> getAllParkingInfo() {
        return parkingService.getAllParkingInfo();
    }
  @PutMapping(path ="/parking", consumes ="application/json")
    public ParkingEntity updateParkingInfo(@RequestParam int slotId, @RequestBody ParkingEntity parkingEntity)
  {
     return  parkingService.updateParkingInfo(slotId,parkingEntity);
  }
  @DeleteMapping(path ="/parking")
   public ParkingEntity delParkingInfo(@RequestParam int slotId){
     return  parkingService.delParkingInfo(slotId);
    }
}
