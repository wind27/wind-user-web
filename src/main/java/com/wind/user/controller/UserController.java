package com.wind.user.controller;

import com.wind.user.model.User;
import com.wind.user.service.IUserService;
import com.wind.utils.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author qianchun 17/9/19
 **/
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    public UserController() {
        System.out.println("-------------------- controller --------------------");
    }

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello";
    }

    @ResponseBody
    @RequestMapping("/user")
    public String getUserById(@RequestParam("id") long id) {
        id = 1L;
        User user = userService.findById(id);
        return JsonResponseUtil.ok(user);
    }
}
