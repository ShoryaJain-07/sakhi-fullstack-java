package team.tp_acsi_api.services;

import team.tp_acsi_api.models.Video;
import team.tp_acsi_api.repositories.VideoRepository;
import team.tp_acsi_api.requests.VideoRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video createVideo(String title, String description) {

        Video video = new Video();
        video.setTitle(title);
        video.setLink(description);

        this.videoRepository.save(video);

        return video;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}