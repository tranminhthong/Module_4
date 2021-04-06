package controller;

import model.entities.Response;
import model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    private Response get(){
        Response res = new Response();
        res.data = customerService.getAll();
        return res;
    }

    @GetMapping("/delete/{id}")
    private Response delete(@PathVariable int id){
        Response response = new Response();
        boolean isDel = customerService.delete(id);
        if (isDel) response.message = "delete success";
        else response.message = "fail";
        return response;
    }
}
