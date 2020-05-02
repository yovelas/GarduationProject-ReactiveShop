package com.hopu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/all")
    String allGoods(){
        return "welcome";
    }
}
