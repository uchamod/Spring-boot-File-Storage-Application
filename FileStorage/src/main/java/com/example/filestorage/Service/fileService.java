package com.example.filestorage.Service;

import com.example.filestorage.Entity.files;
import com.example.filestorage.Repostory.repostory;
import com.example.filestorage.Util.fileUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
public class fileService {

    @Autowired
    private repostory repo;

    //MultipartFile is a class that we can get all the info about the file
    public String uploadFile(MultipartFile file) throws IOException {

                    files fileData=repo.save(files.builder()     //builder is used to build the filedata components(name,type,bytecode)
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .fileData(fileUtil.compressImage(file.getBytes())).build());

                    if(fileData != null){
                        return "file uploded succssfuly"+file.getOriginalFilename();
                    }else{
                        return "file is not uploded ";
                    }


    }

    public byte[] downloadFile(String filename){
        Optional<files> file=repo.findByName(filename);
        byte[] decomFile=fileUtil.decompressImage(file.get().getFileData());
        return decomFile;

    }


}
