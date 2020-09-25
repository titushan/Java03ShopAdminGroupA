package com.bwf.shop.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用控制器
 * */
@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping( "/permissionerror" )
    public String permissionerror(){
        return null;
    }


    @RequestMapping("/success")
    public String success(){
        return null;
    }


    @RequestMapping("/error")
    public String error(){
        return null;
    }

}
