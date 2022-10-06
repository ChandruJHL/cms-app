package com.itss.cms.service;
import com.itss.cms.dto.CollegeRequest;
import com.itss.cms.dto.CollegeResponse;
import com.itss.cms.entity.CanteenEntity;
import com.itss.cms.entity.CollegeEntity;
import com.itss.cms.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    CollegeRepository CollegeRepository;


    public void persistCollege(CollegeRequest college) {
        CollegeEntity collegeEntity = new CollegeEntity();
        collegeEntity.setContactNumber(college.getContactNumber());
        collegeEntity.setCollegeName(college.getCollegeName());
        collegeEntity.setCity(college.getCity());
        CollegeRepository.save(collegeEntity);
    }

    public CollegeResponse getCollegeInfo(int contactNumber) {
         CollegeResponse collegeResponse = new CollegeResponse();
         CollegeEntity collegeEntity = CollegeRepository.findById(contactNumber).get();
         collegeResponse.setContactNumber(collegeEntity.getContactNumber());
         collegeResponse.setCollegeName(collegeEntity.getCollegeName());
         collegeResponse.setCity(collegeEntity.getCity());

         return collegeResponse;
    }

}
