package me.theowm.edufyvideouploaderservice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Uploader {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uploader_id", columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;

    @Column(length = 70, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "uploader_video_ids", joinColumns = @JoinColumn(name = "uploader_id"))
    @Column(name = "video_id", columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private List<UUID> videos = new ArrayList<>();

    public Uploader() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UUID> getVideos() {
        return videos;
    }

    public void setVideos(List<UUID> videos) {
        this.videos = videos;
    }
}
