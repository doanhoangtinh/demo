package com.dhtinh.demo.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.dhtinh.demo.config.GenerateDateTime;
import com.dhtinh.demo.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Autowired
    private GenerateDateTime generateDateTime;

    private final Path root = Paths.get("./uploads");

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String store(MultipartFile file) {
        try {
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),
                    file.getOriginalFilename().length());
            String fileName = generateDateTime.getString() + extension;
            System.out.println(fileName);
            Files.copy(file.getInputStream(), this.root.resolve(fileName));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Không thể load file");

        }

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }
}
