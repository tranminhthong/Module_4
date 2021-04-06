package controller;

import entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.BlogService;
import service.IBlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
     private IBlogService blogService;

    @GetMapping("/")
    public String showFormAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog){
        blogService.createNewBlog(blog);
        return ("/create");
    }

    @GetMapping("/view")
    public ModelAndView view(){
        Blog blog = blogService.viewBlog(1);
        ModelAndView model = new ModelAndView("/view");
        model.addObject("blog", blog);
        return model;
    }
}
