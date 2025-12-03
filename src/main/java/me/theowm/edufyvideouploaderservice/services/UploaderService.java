package me.theowm.edufyvideouploaderservice.services;

import me.theowm.edufyvideouploaderservice.entities.Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.theowm.edufyvideouploaderservice.repositories.UploaderRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UploaderService implements UploaderServiceInterface {

    private final UploaderRepository uploaderRepository;

    @Autowired
    public UploaderService(UploaderRepository uploaderRepository) {
        this.uploaderRepository = uploaderRepository;
    }

    @Override
    public List<Uploader> fetchAllUploaders() {
        return uploaderRepository.findAll();
    }

    @Override
    public Uploader addNewUploader(Uploader uploader) {
        return uploaderRepository.save(uploader);
    }

    @Override
    public Uploader updateUploader(UUID id, Uploader uploader) {
        return uploaderRepository.save(uploader);
    }

    @Override
    public void deleteUploader(UUID id) {
        uploaderRepository.deleteById(id);
    }

    @Override
    public Uploader fetchUploader(UUID id) {
        return uploaderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Uploader not found: " + id));
    }
}
