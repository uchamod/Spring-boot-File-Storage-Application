package com.example.filestorage.Controller;

import com.example.filestorage.Service.fileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
@CrossOrigin
public class fileController {

    @Autowired
    private fileService service;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("image")MultipartFile file) throws IOException {  //when use multipartfile we have to annotate requestparam
        String respons=service.uploadFile(file);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(respons);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename){
        byte[] respons=service.downloadFile(filename);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(respons);
    }

}
