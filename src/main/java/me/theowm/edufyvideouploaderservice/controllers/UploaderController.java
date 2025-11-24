package me.theowm.edufyvideouploaderservice.controllers;

import me.theowm.edufyvideouploaderservice.entities.Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import me.theowm.edufyvideouploaderservice.services.UploaderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/uploaders")
public class UploaderController {

    private final UploaderService uploaderService;

    @Autowired
    public UploaderController(UploaderService uploaderService) {
        this.uploaderService = uploaderService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/alluploaders")
    public ResponseEntity<List<Uploader>> getAllUploaders() {
        return ResponseEntity.ok(uploaderService.fetchAllUploaders());
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/adduploader")
    public ResponseEntity<Uploader> addNewUploader(@RequestBody Uploader uploader) {
        return new ResponseEntity<>(uploaderService.addNewUploader(uploader), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/deleteuploader/{uploaderId}")
    public ResponseEntity<String> deleteUploaderById(@PathVariable UUID uploaderId){
        uploaderService.deleteUploader(uploaderId);
        return ResponseEntity.ok("Uploader with id " + uploaderId + " was deleted");
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/updateuploader/{uploaderId}")
    public ResponseEntity<Uploader> updateUploader(@PathVariable UUID uploaderId, @RequestBody Uploader uploader){
        return ResponseEntity.ok(uploaderService.updateUploader(uploaderId, uploader));
    }

}
