package com.me.forum.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "hello world123";
    }
}
