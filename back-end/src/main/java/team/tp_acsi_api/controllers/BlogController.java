package team.tp_acsi_api.controllers;

import team.tp_acsi_api.models.Blog;
import team.tp_acsi_api.requests.BlogRequest;
import team.tp_acsi_api.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody BlogRequest blog) {
        String title = blog.getTitle();
        String description = blog.getDescription();
        Blog savedBlog = blogService.createBlog(title, description);
        return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}