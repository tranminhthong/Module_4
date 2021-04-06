package controller;

import model.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/email")
public class ConfigEmailController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("email",new EmailConfig());
        return "/index";
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute EmailConfig emailConfig,Model model){
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("email",emailConfig);
        return modelAndView;
    }
}
