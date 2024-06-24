package team.tp_acsi_api.controllers;

import team.tp_acsi_api.models.Video;
import team.tp_acsi_api.requests.VideoRequest;
import team.tp_acsi_api.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody VideoRequest video) {
        String title = video.getTitle();
        String link = video.getLink();
        Video savedVideo = videoService.createVideo(title, link);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
}