package com.wanglu.tmall.controller;

import com.wanglu.tmall.model.User;
import com.wanglu.tmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by wanglu on 17/2/23.
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerPage(ModelMap map) {
        User user = new User();
        map.addAttribute("user", user);
//        map.addAttribute("msg","nihao");
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result, ModelMap map, HttpSession session) {


        if (result.hasErrors()) {
            //  map.addAttribute("user",user);
            map.addAttribute("msg", "user error");
            return "register";
        }
        if (userService.isUserExist(user)) {
            map.addAttribute("msg", "user already exist");
        } else {
            userService.saveUser(user);
            map.addAttribute("msg", "user registe success");
            session.setAttribute("user",user);
            return "registerSuccess";
        }

        return "regist";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(ModelMap map) {
        User user = new User();
        map.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@Valid User user, HttpSession session, BindingResult result, ModelMap map) {

        if (result.hasErrors()) {
            map.addAttribute("msg", "user or password error");
            return "login";
        }
        if (userService.checkUser(user)) {
            session.setAttribute("user", user);
            return "redirect:".concat("forehome");
        } else {
            map.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

    }
    @RequestMapping(value = "forelogout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:forehome";
    }
}
