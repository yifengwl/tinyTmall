package com.wanglu.tmall.controller;

import com.wanglu.tmall.model.Category;
import com.wanglu.tmall.model.Product;
import com.wanglu.tmall.service.CategoryService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
//@RequestMapping("/")
public class AppController {


    @Resource(name = "categoryService")
    CategoryService service;

    @Resource
    MessageSource messageSource;
//    private Logger logger = Logger.getLogger(this.getClass().getName());


    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = {"forehome"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {

        List<Product> c = service.findByCategoryID(60);
        List<Category> categorys = service.findAllCategory();
        model.addAttribute("cs", categorys);
        return "home";
    }
}