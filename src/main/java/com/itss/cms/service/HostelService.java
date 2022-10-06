package com.itss.cms.service;
import com.itss.cms.dto.HostelRequest;
import com.itss.cms.dto.HostelResponse;
import com.itss.cms.entity.HostelEntity;
import com.itss.cms.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostelService {
    @Autowired
    HostelRepository hostelRepository;

    public void persistHostel(HostelRequest student) {
        HostelEntity hostelEntity = new HostelEntity();
        student.setStudentId(hostelEntity.getStudentId());
        student.setBlockNumber(hostelEntity.getBlockNumber());
        student.setRoomNumber(hostelEntity.getRoomNumber());
        hostelRepository.save(hostelEntity);
    }

    public HostelResponse getHostelStudentInfo(int studentId) {
        HostelResponse hostelResponse = new HostelResponse();
        HostelEntity hostelEntity = hostelRepository.findById(studentId).get();
        hostelResponse.setStudentId(hostelEntity.getStudentId());
        hostelResponse.setRoomNumber(hostelEntity.getRoomNumber());
        hostelResponse.setBlockNumber(hostelEntity.getBlockNumber());
        return hostelResponse;
    }
    public HostelEntity updateHostelInfo(int studentId, HostelEntity hostelInfo) {
        HostelEntity existingHostelInfo;
        existingHostelInfo = hostelRepository.findById(studentId).get();
        if(existingHostelInfo == null) {
            System.out.println("user id invalid");
        } else {
            existingHostelInfo.setRoomNumber(hostelInfo.getRoomNumber());
            hostelRepository.save(existingHostelInfo);
        }
        return existingHostelInfo;
    }

    public HostelEntity delHostelInfo(int studentId) {
        HostelEntity existingHostelInfo;
        existingHostelInfo = hostelRepository.findById(studentId).get();
        if (existingHostelInfo == null) {
            System.out.println("user is invalid");
        } else {
            hostelRepository.delete(existingHostelInfo);
        }
        return existingHostelInfo;
    }

}
