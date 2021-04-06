package service;

import entities.Blog;

import java.util.List;

public interface IBlogService {
    void createNewBlog(Blog blog);
    List<Blog> findAll();
    Blog viewBlog(int id);
    void updateBlog(Blog newBlog);
    void deleteBlog(int id);
}
