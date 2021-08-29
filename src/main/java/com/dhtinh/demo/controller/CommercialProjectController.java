// package com.dhtinh.demo.controller;

// import static com.dhtinh.demo.common.UrlConstant.PROJECT;

// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.ArrayList;
// import java.util.List;

// import com.dhtinh.demo.dto.CommercialProjectDTO;
// import com.dhtinh.demo.model.request.CommercialRequestModel;
// import com.dhtinh.demo.model.response.CommercialResponseModel;
// import com.dhtinh.demo.service.CommercialProjectService;
// import com.dhtinh.demo.service.FieldService;
// import com.dhtinh.demo.service.FileStorageService;
// import com.dhtinh.demo.service.StatusService;
// import com.dhtinh.demo.service.UserProfileService;
// import com.dhtinh.demo.service.UserService;

// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.Resource;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// @RestController
// @RequestMapping(PROJECT)
// public class SubmitCommercialProjectController {
//     @Autowired
//     private CommercialProjectService commercialProjectService;
//     @Autowired
//     private ModelMapper mapper;
//     @Autowired
//     private UserService userService;
//     @Autowired
//     private FieldService fieldService;
//     @Autowired
//     private StatusService statusService;
//     @Autowired
//     private UserProfileService userProfileService;
//     @Autowired
//     private FileStorageService fileStorageService;

//     @PostMapping
//     public ResponseEntity<CommercialResponseModel> createCommercialProject(
//             @ModelAttribute CommercialRequestModel commercialRequestModel, MultipartFile[] files) {
//         // System.out.println(file[0].getOriginalFilename());
//         // System.out.println(commercialRequestModel.getScope());

//         CommercialProjectDTO commercialProjectDTO = new CommercialProjectDTO();
//         mapper.map(commercialRequestModel, commercialProjectDTO);
//         commercialProjectDTO.setUser(userProfileService.getUserProfile(commercialRequestModel.getUserId()));
//         commercialProjectDTO.setField(fieldService.getField(commercialRequestModel.getFieldId()));
//         commercialProjectDTO.setStatus(statusService.getStatus(commercialRequestModel.getStatusId()));
//         CommercialProjectDTO commercialCreated = commercialProjectService.createCommercialProject(commercialProjectDTO);

//         List<String> url = new ArrayList<>();

//         for (MultipartFile multipartFile : files) {
//             System.out.println(multipartFile);
//             fileStorageService.store(multipartFile);
//             String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(PROJECT+"/download/")
//                     .path(multipartFile.getOriginalFilename()).toUriString();
//             url.add(uri);

//         }

//         if (commercialCreated == null) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//         }
//         CommercialResponseModel commercialResponseModel = new CommercialResponseModel();
//         mapper.map(commercialCreated, commercialResponseModel);
//         commercialResponseModel.setFile(url);
//         return ResponseEntity.ok().body(commercialResponseModel);
//     }

//     @GetMapping("/download/{filename:.+}")
//     @ResponseBody
//     public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

//         Resource resource = fileStorageService.loadAsResource(filename);
//         try {
//             Path path = resource.getFile().toPath();
//             String s = Files.probeContentType(path);
//             return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, s).body(resource);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//         return ResponseEntity.ok().body(null);

//         // return ResponseEntity.ok()
//         // .header(HttpHeaders.CONTENT_DISPOSITION,
//         // "attachment; filename=\"" + resource.getFilename() + "\"")
//         // .body(resource);
//     }

// }

package com.dhtinh.demo.controller;

import static com.dhtinh.demo.common.UrlConstant.PROJECT;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.dhtinh.demo.dto.CommercialProjectDTO;
import com.dhtinh.demo.dto.StatusDTO;
import com.dhtinh.demo.dto.UserProfileDTO;
import com.dhtinh.demo.model.request.CommercialRequestModel;
import com.dhtinh.demo.model.response.CommercialResponseModel;
import com.dhtinh.demo.service.CommercialProjectService;
import com.dhtinh.demo.service.FieldService;
import com.dhtinh.demo.service.FileStorageService;
import com.dhtinh.demo.service.LevelDevelopmentService;
import com.dhtinh.demo.service.StatusService;
import com.dhtinh.demo.service.TransmissionMethodService;
import com.dhtinh.demo.service.UserProfileService;
import com.dhtinh.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(PROJECT)
public class CommercialProjectController {
    @Autowired
    private CommercialProjectService commercialProjectService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserService userService;
    @Autowired
    private FieldService fieldService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private LevelDevelopmentService levelDevelopmentService;
    @Autowired
    private TransmissionMethodService transmissionMethodService;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private FileStorageService fileStorageService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<CommercialResponseModel> createCommercialProject(
            @RequestBody CommercialRequestModel commercialRequestModel) {
        CommercialProjectDTO commercialProjectDTO = new CommercialProjectDTO();
        mapper.map(commercialRequestModel, commercialProjectDTO);
        commercialProjectDTO.setUser(userProfileService.getUserProfile(commercialRequestModel.getUser()));
        commercialProjectDTO.setField(fieldService.getField(commercialRequestModel.getField()));
        commercialProjectDTO.setStatus(statusService.getStatus(commercialRequestModel.getStatus()));
        commercialProjectDTO.setLevelDevelopment(
                levelDevelopmentService.getLevelDevelopment(commercialRequestModel.getLevelDevelopment()));
        commercialProjectDTO.setTransmissionMethod(
                transmissionMethodService.getTransmissionMethod(commercialRequestModel.getTransmissionMethod()));
        CommercialProjectDTO commercialCreated = commercialProjectService.createCommercialProject(commercialProjectDTO);

        if (commercialCreated == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        CommercialResponseModel commercialResponseModel = new CommercialResponseModel();
        mapper.map(commercialCreated, commercialResponseModel);
        return ResponseEntity.ok().body(commercialResponseModel);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<CommercialResponseModel> updateCommercialProject(@PathVariable Long id,
            @RequestBody CommercialRequestModel commercialRequestModel) {
        CommercialProjectDTO commercialProjectDTO = new CommercialProjectDTO();
        mapper.map(commercialRequestModel, commercialProjectDTO);
        commercialProjectDTO.setUser(userProfileService.getUserProfile(commercialRequestModel.getUser()));
        commercialProjectDTO.setField(fieldService.getField(commercialRequestModel.getField()));
        commercialProjectDTO.setStatus(statusService.getStatus(commercialRequestModel.getStatus()));
        commercialProjectDTO.setLevelDevelopment(
                levelDevelopmentService.getLevelDevelopment(commercialRequestModel.getLevelDevelopment()));
        commercialProjectDTO.setTransmissionMethod(
                transmissionMethodService.getTransmissionMethod(commercialRequestModel.getTransmissionMethod()));
        CommercialProjectDTO commercialUpdated = commercialProjectService.updateCommercialProject(id,
                commercialProjectDTO);

        if (commercialUpdated == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        CommercialResponseModel commercialResponseModel = new CommercialResponseModel();
        mapper.map(commercialUpdated, commercialResponseModel);
        return ResponseEntity.ok().body(commercialResponseModel);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<CommercialResponseModel> getCommercialProject(@PathVariable Long id) {
        CommercialProjectDTO commercialProjectDTO = commercialProjectService.getCommercialProject(id);
        commercialProjectService.createCommercialProject(commercialProjectDTO);
        if (commercialProjectDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        CommercialResponseModel commercialResponseModel = new CommercialResponseModel();
        mapper.map(commercialProjectDTO, commercialResponseModel);
        return ResponseEntity.ok().body(commercialResponseModel);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<CommercialResponseModel>> getCommercialProjects() {
        List<CommercialProjectDTO> commercialProjectDTOs = commercialProjectService.getCommercialProjects();
        if (commercialProjectDTOs == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        List<CommercialResponseModel> commercialResponseModels = mapper.map(commercialProjectDTOs,
                new TypeToken<List<CommercialResponseModel>>() {
                }.getType());
        return ResponseEntity.ok().body(commercialResponseModels);
    }

    @CrossOrigin
    @GetMapping("/user/{userId}/status/{statusId}")
    public ResponseEntity<List<CommercialResponseModel>> getCommercialProjects(@PathVariable Long userId,
            @PathVariable Long statusId) {
        UserProfileDTO userProfileDTO = userProfileService.getUserProfile(userId);
        StatusDTO statusDTO = statusService.getStatus(statusId);
        List<CommercialProjectDTO> commercialProjectDTOs = commercialProjectService
                .getCommercialProjects(userProfileDTO, statusDTO);
        if (commercialProjectDTOs == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        List<CommercialResponseModel> commercialResponseModels = mapper.map(commercialProjectDTOs,
                new TypeToken<List<CommercialResponseModel>>() {
                }.getType());
        return ResponseEntity.ok().body(commercialResponseModels);
    }

    @CrossOrigin
    @GetMapping("/status/{statusId}")
    public ResponseEntity<List<CommercialResponseModel>> getCommercialProjects(@PathVariable Long statusId) {
        try {
            StatusDTO statusDTO = statusService.getStatus(statusId);
            List<CommercialProjectDTO> commercialProjectDTOs = commercialProjectService
                    .getCommercialProjects(statusDTO);
            List<CommercialResponseModel> commercialResponseModels = mapper.map(commercialProjectDTOs,
                    new TypeToken<List<CommercialResponseModel>>() {
                    }.getType());
            return ResponseEntity.ok().body(commercialResponseModels);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @CrossOrigin
    @DeleteMapping
    public ResponseEntity<Boolean> deleteCommercialProjects() {
        commercialProjectService.deleteCommercialProjects();
        return ResponseEntity.ok(true);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCommercialProject(@PathVariable Long id) {
        commercialProjectService.deleteCommercialProject(id);
        return ResponseEntity.ok(true);
    }

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
