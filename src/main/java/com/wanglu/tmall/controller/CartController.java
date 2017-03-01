package com.wanglu.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wanglu on 17/3/1.
 */
@Controller
public class CartController {

    @RequestMapping(name = "foreaddCart", method = RequestMethod.GET)
    @ResponseBody
    public String cart(@RequestParam("pid")int pid,@RequestParam("num")int num) {
        return "success";
    }
}
