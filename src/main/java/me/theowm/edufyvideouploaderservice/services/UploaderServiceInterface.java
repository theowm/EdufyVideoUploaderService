package me.theowm.edufyvideouploaderservice.services;

import me.theowm.edufyvideouploaderservice.entities.Uploader;

import java.util.List;
import java.util.UUID;

public interface UploaderServiceInterface {
    List<Uploader> fetchAllUploaders();
    Uploader addNewUploader(Uploader uploader);
    Uploader updateUploader(UUID id, Uploader uploader);
    void deleteUploader(UUID id);
}
