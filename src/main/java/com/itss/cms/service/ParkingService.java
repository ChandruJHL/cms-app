package com.itss.cms.service;
import com.itss.cms.dto.ParkingRequest;
import com.itss.cms.dto.ParkingResponse;
import com.itss.cms.entity.ParkingEntity;
import com.itss.cms.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ParkingService {
    @Autowired
    ParkingRepository  parkingRepository;
    public void persisParkingInfo(ParkingRequest parkingInfo){
        ParkingEntity parkingEntity = new ParkingEntity();
        parkingEntity.setSlotId(parkingInfo.getSlotId());
        parkingEntity.setVehicleOwnerName(parkingInfo.getVehicleOwnerName());
        parkingEntity.setVehicleNumber(parkingInfo.getVehicleNumber());
        parkingRepository.save(parkingEntity);
    }
    public ParkingResponse getParkingDetail(int ParkingId){

        ParkingResponse parkingResponse = new ParkingResponse();
        ParkingEntity parkingEntity = parkingRepository.findById(ParkingId).get();
        parkingResponse.setSlotId(parkingEntity.getSlotId());
        parkingResponse.setVehicleOwnerName(parkingEntity.getVehicleOwnerName());
        parkingResponse.setVehicleNumber(parkingEntity.getVehicleNumber());
        return  parkingResponse;
    }

    public ArrayList<ParkingResponse> getAllParkingInfo() {
     ArrayList<ParkingResponse> parkingResponses = new ArrayList<>();
     ArrayList<ParkingEntity> parking = (ArrayList<ParkingEntity>) parkingRepository.findAll();
     for(int i = 0; i < parking.size(); i++) {
         ParkingEntity parkingEntity = parking.get(i);
         ParkingResponse parkingResponse = new ParkingResponse();
         parkingResponse.setSlotId(parkingEntity.getSlotId());
         parkingResponse.setVehicleNumber(parkingEntity.getVehicleNumber());
         parkingResponse.setVehicleOwnerName(parkingEntity.getVehicleOwnerName());
         parkingResponses.add(parkingResponse);

     }
        return parkingResponses;
    }

   public ParkingEntity updateParkingInfo(int slotId , ParkingEntity parkingEntity){
        ParkingEntity existingParkingEntity ;
        existingParkingEntity = parkingRepository.findById(slotId).get();
        if(existingParkingEntity == null){
            System.out.println("invalid id ");
        } else{
            existingParkingEntity.setVehicleOwnerName(parkingEntity.getVehicleOwnerName());
        }
        return parkingRepository.save(existingParkingEntity);
   }

    public ParkingEntity delParkingInfo(int slotId ) {
        ParkingEntity existingParkingEntity;
        existingParkingEntity = parkingRepository.findById(slotId).get();
        if (existingParkingEntity == null) {
            System.out.println("invalid id ");
        } else {
            parkingRepository.delete(existingParkingEntity);
        }
        return existingParkingEntity;
    }

}
