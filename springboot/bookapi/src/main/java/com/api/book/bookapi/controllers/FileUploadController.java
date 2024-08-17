package com.api.book.bookapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bookapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;
    
    @PostMapping("/uploadImage")
    public ResponseEntity<String> handler(@RequestParam("photo") MultipartFile file){
        // System.out.println(m.getSize());
        // System.out.println(m.getName());
        // System.out.println(m.getOriginalFilename());
        // return "wow its working!";

        try{
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            if(!file.getContentType().equals("image/jpeg")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPED content is allowed!!");
            }

            boolean check = fileUploadHelper.uploadFile(file);
            if(check){
                // return ResponseEntity.ok("file uploaded");
                return ResponseEntity.
                ok(ServletUriComponentsBuilder.
                fromCurrentContextPath().path("/image/").
                path(file.getOriginalFilename()).toUriString());
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
