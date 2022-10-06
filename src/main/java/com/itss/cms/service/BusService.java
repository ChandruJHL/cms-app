package com.itss.cms.service;

import com.itss.cms.entity.BusEntity;
import com.itss.cms.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    @Autowired
    BusRepository busRepository;
    public void persistBusInfo(BusEntity busInfo){
        busRepository.save(busInfo);
    }
    public BusEntity getBusDetail(int busId){
        return  busRepository.findById(busId).get();
    }

}
