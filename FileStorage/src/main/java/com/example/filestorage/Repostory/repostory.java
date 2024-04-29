package com.example.filestorage.Repostory;

import com.example.filestorage.Entity.files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface repostory extends JpaRepository<files,Long> {

    Optional<files> findByName(String fileName);

}
