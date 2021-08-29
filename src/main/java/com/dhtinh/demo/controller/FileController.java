package com.dhtinh.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.dhtinh.demo.common.UrlConstant.FILE;

import com.dhtinh.demo.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(FILE)
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<List<String>> fileUploadHandling(@RequestParam("files") MultipartFile[] files) {

        List<String> url = new ArrayList<>();

        for (MultipartFile multipartFile : files) {
           String fileName = fileStorageService.store(multipartFile);
            String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(FILE + "/download/")
                    .path(fileName).toUriString();
            url.add(uri);

        }
        return ResponseEntity.ok().body(url);
    }

    @CrossOrigin
    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        Resource resource = fileStorageService.loadAsResource(filename);
        try {
            Path path = resource.getFile().toPath();
            String s = Files.probeContentType(path);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, s).body(resource);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok().body(null);

        // return ResponseEntity.ok()
        // .header(HttpHeaders.CONTENT_DISPOSITION,
        // "attachment; filename=\"" + resource.getFilename() + "\"")
        // .body(resource);
    }

}

