package com.itss.cms.service;
import com.itss.cms.dto.LibraryRequest;
import com.itss.cms.dto.LibraryResponse;
import com.itss.cms.entity.LibraryEntity;
import com.itss.cms.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository  libRepository;
    public void persistLibInfo(LibraryRequest libInfo){
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setLibraryId(libInfo.getId());
        libraryEntity.setLibraryName(libInfo.getLibraryName());
        libraryEntity.setBookSection(libInfo.getBookSection());
        libraryEntity.setTotalBook(libInfo.getTotalBook());
        libRepository.save(libraryEntity);
    }
    public LibraryResponse getLibDetail(int libId){

        LibraryEntity libraryEntity= libRepository.findById(libId).get();
        LibraryResponse libraryResponse = new LibraryResponse();
        libraryResponse.setId(libraryEntity.getLibraryId());
        libraryResponse.setLibraryName(libraryEntity.getLibraryName());
        libraryResponse.setBookSection(libraryEntity.getBookSection());
        libraryResponse.setTotalBook(libraryEntity.getTotalBook());
        return libraryResponse;
    }

    public ArrayList<LibraryResponse> getAllLibInfo() {

        ArrayList<LibraryEntity> libraryEntity = (ArrayList<LibraryEntity>)libRepository.findAll();
        ArrayList<LibraryResponse> libraryResponses = new ArrayList<>();
        for(int i=1; i<libraryEntity.size();i++){
            LibraryEntity libEntity = libraryEntity.get(i);
            LibraryResponse libraryResponse = new LibraryResponse();
            libraryResponse.setId(libEntity.getLibraryId());
            libraryResponse.setLibraryName(libEntity.getLibraryName());
            libraryResponse.setBookSection(libEntity.getBookSection());
            libraryResponse.setTotalBook(libEntity.getTotalBook());
            libraryResponses.add(libraryResponse);
        }
        return libraryResponses;
    }
    public  LibraryEntity updateLibInfo(int libId , LibraryEntity libraryEntity ){
        LibraryEntity existingLibrary;
        existingLibrary = libRepository.findById(libId).get();
        if(existingLibrary == null){
            System.out.println("Invalid Id");
        }else{
            existingLibrary.setTotalBook(libraryEntity.getTotalBook());
            existingLibrary.setBookSection(libraryEntity.getBookSection());
        }
        return libRepository.save(existingLibrary);
    }

    public LibraryEntity delLibInfo(int libId) {
        LibraryEntity existingLibrary;
        existingLibrary = libRepository.findById(libId).get();
        if (existingLibrary == null) {
            System.out.println("Invalid Library Id");
        } else {
            libRepository.delete(existingLibrary);
        }
        return existingLibrary;
    }

}
