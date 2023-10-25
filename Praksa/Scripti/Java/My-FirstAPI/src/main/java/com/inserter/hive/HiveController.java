package com.inserter.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class HiveController {

    @Autowired private HiveService hiveService;

    @PostMapping("/hive")
    public void insertDataInHive(@RequestBody MultipartFile csvFile){
        hiveService.insertDataInHiveFromFile(csvFile);
    }

}