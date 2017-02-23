package com.wanglu.tmall.controller;

import com.wanglu.tmall.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wanglu on 17/2/23.
 */
@Controller
public class UserController {
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerPage( ModelMap map){
        User user = new User();
        map.addAttribute("user",user);
        return "register";
    }
}
