package team.tp_acsi_api.services;

import team.tp_acsi_api.models.Blog;
import team.tp_acsi_api.repositories.BlogRepository;
import team.tp_acsi_api.requests.BlogRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog createBlog(String title, String description) {

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setDescription(description);

        this.blogRepository.save(blog);

        return blog;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}