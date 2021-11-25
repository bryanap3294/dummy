package com.bryan.uploadfile.controller;

import com.bryan.uploadfile.config.PropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("prueba")
public class PruebaController {

    @Autowired
    PropertiesConfig propertiesConfig;

    private final Path root = Paths.get("uploads");


    Logger logger = LoggerFactory.getLogger(PruebaController.class);

    @GetMapping("/holi")
    public String helloWorld() {
        return "JOJOJO";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file) {

        try{
            logger.error("HOLITAS");
            Path newRoute = Paths.get(this.propertiesConfig.getFileTempPath());
            //Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), newRoute.resolve(file.getOriginalFilename()));
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return "sss";
    }

}
