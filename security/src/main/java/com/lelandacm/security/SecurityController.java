package com.lelandacm.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

    @RequestMapping("/")
    public String index(){
        return "index" ;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello" ;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return  "login" ;
    }

    @RequestMapping("/home")
    public String home(){
        return  "home" ;
    }
}
