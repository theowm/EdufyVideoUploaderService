package me.theowm.edufyvideouploaderservice.repositories;

import me.theowm.edufyvideouploaderservice.entities.Uploader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UploaderRepository extends JpaRepository<Uploader, UUID> {
}
