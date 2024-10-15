package com.sample.spring.controller;

import com.sample.spring.service.FileDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    FileDataService fileDataService;

    @PostMapping("/file")
    public ResponseEntity<?> uploadImage(
            @RequestParam("images")List<MultipartFile> files
            ){
        List<String> uploadResult = files.stream().map(file->{
            try{
                return fileDataService.uploadImageToFileSystem(file);
            }catch (IOException e){
                e.printStackTrace();
                return "failed to upload";
            }
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(uploadResult);
    }
    @GetMapping("/file/{id}")
    public ResponseEntity<?> downImage(
            @PathVariable("id") Long id
    ) throws IOException{

        byte[] downLoadImage = fileDataService.downloadImageFileSystem(id);
        if (downLoadImage != null){
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(downLoadImage);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
