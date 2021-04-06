package service;

import entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IBlogRepo;

import java.util.List;

public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public void createNewBlog(Blog blog) {
        blogRepo.createNewBlog(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog viewBlog(int id) {
        return blogRepo.viewBlog(id);
    }

    @Override
    public void updateBlog(Blog newBlog) {
        blogRepo.updateBlog(newBlog);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepo.deleteBlog(id);
    }
}
