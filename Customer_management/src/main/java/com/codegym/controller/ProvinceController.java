package com.codegym.controller;

import com.codegym.entities.Customer;
import com.codegym.entities.Province;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import com.codegym.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces() {
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        try {
            provinceService.save(province);
        } catch (DuplicateEmailException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws Exception {
        Province province = provinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        try {
            provinceService.save(province);
        } catch (DuplicateEmailException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) throws Exception {
        Province province = provinceService.findById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province);
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id) throws Exception {
        Province province = provinceService.findById(id);
        if(province == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(province);

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
