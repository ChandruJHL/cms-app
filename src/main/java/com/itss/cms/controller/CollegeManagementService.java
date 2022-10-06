package com.itss.cms.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@RestController
public class CollegeManagementService {

    ArrayList<String> names = new ArrayList<>();
    @GetMapping(path = "/name")
    public String getName() {
        return "Mallesh";
    }

    @GetMapping(path = "/add")
    public int addition(@RequestParam int number1, @RequestParam int number2) {
        int result = number1 + number2;
        return result;
    }

    @PostMapping(path = "/addName")
    public void storeName(@RequestParam String name) {
        names.add(name);
    }

    @GetMapping("/getNames")
    public String getNames() {
        String storedNames = "";
        for (int i =0; i< names.size(); i++) {
            storedNames = storedNames.concat(names.get(i));
            storedNames = storedNames.concat(",");
        }
        return storedNames;

    }

    @DeleteMapping(path = "/deleteName")
    public int deleteName(@RequestParam int index) {
        names.remove(index);
        return index;
    }

}