package com.itss.cms.service;
import com.itss.cms.dto.StaffRequest;
import com.itss.cms.dto.StaffResponse;
import com.itss.cms.dto.StudentResponse;
import com.itss.cms.entity.StaffEntity;
import com.itss.cms.entity.StudentEntity;
import com.itss.cms.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StaffService {
    @Autowired

    StaffRepository staffRepository;
    public void persistStaffInfo(StaffRequest staffInfo){
       StaffEntity staffEntity = new StaffEntity();
       staffEntity.setStaffId(staffInfo.getId());
       staffEntity.setStaffName(staffInfo.getName());
       staffEntity.setDeptId(staffInfo.getDeptId());
       staffEntity.setSalary(staffInfo.getSalary());
       staffRepository.save(staffEntity);
    }
    public StaffResponse getStaffDetail(int staffId){

        StaffEntity staffEntity = staffRepository.findById(staffId).get();
        StaffResponse staffResponse = new StaffResponse();
        staffResponse.setId((short) staffEntity.getStaffId());
        staffResponse.setName(staffEntity.getStaffName());
        staffResponse.setDeptId(staffEntity.getDeptId());
        staffResponse.setSalary(staffEntity.getSalary());
        return staffResponse;
    }
    public ArrayList<StaffResponse> getAllStaffInfo() {
        ArrayList<StaffEntity> staffInfo = (ArrayList<StaffEntity>)staffRepository.findAll();
        ArrayList<StaffResponse> staffResponses = new ArrayList<>();
        for (int i = 0; i < staffInfo.size(); i++) {

            StaffEntity staffEntity = staffInfo.get(i);
            StaffResponse staffResponse = new StaffResponse();
            staffResponse.setId((short) staffEntity.getStaffId());
            staffResponse.setName(staffEntity.getStaffName());
            staffResponse.setDeptId(staffEntity.getDeptId());
            staffResponse.setSalary(staffEntity.getSalary());
            staffResponses.add(staffResponse);
        }
        return staffResponses;
    }
    public StaffEntity updateStaffInfo(int staffId, StaffEntity staffEntity) {
        StaffEntity existingStaffEntity ;
        existingStaffEntity = staffRepository.findById(staffId).get();
        if(existingStaffEntity == null){
            System.out.println("Invalid Id");
        }else{
            existingStaffEntity.setStaffName(staffEntity.getStaffName());
            existingStaffEntity.setSalary(staffEntity.getSalary());
            staffRepository.save(existingStaffEntity);
        }
      return existingStaffEntity;
    }
    public  StaffEntity delStaffInfo(int staffId){
        StaffEntity existingStaffEntity ;
        existingStaffEntity = staffRepository.findById(staffId).get();
        if(existingStaffEntity == null){
            System.out.println("Invalid id ");
        }else{
            staffRepository.delete(existingStaffEntity);
        }
        return existingStaffEntity;
    }
}
