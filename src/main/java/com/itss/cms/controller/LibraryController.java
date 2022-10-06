package com.itss.cms.controller;

import com.itss.cms.dto.LibraryRequest;
import com.itss.cms.dto.LibraryResponse;
import com.itss.cms.entity.LibraryEntity;
import com.itss.cms.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LibraryController {
    // Library Details
    @Autowired
    LibraryService libraryService;

    @PostMapping(path = "/lib", consumes = "application/json")
    public String addLibInfo(@RequestBody LibraryRequest libInfo) {
        libraryService.persistLibInfo(libInfo);
        return "Accepted";
    }

    @GetMapping(path = "/lib")
    public LibraryResponse getLibInfo(@RequestParam int libId) {

        return libraryService.getLibDetail(libId);
    }
    @GetMapping(path ="lib/all")
    public ArrayList<LibraryResponse> getALlLibInfo(){
        return libraryService.getAllLibInfo();
    }
    @PutMapping(path ="/lib", consumes = "application/json")
    public LibraryEntity updateLibInfo(@RequestParam int libId, @RequestBody LibraryEntity libraryEntity){
       return  libraryService.updateLibInfo(libId,libraryEntity);

    }
    @DeleteMapping(path ="/lib")
    public  LibraryEntity delLibInfo(@RequestParam int libId){
        return  libraryService.delLibInfo(libId);
    }

}
