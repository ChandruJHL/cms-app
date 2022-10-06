package com.itss.cms.service;
import com.itss.cms.entity.CanteenEntity;
import com.itss.cms.repository.CanteenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanteenService {
    @Autowired
        CanteenRepository  canteenRepository;
        public void persistCanteenInfo(CanteenEntity CanteenInfo){
            canteenRepository.save(CanteenInfo);
        }
        public CanteenEntity getCanteenDetail(int inChargeId){

            return  canteenRepository.findById(inChargeId).get();
        }

}
