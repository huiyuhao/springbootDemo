package com.huiyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

   @Autowired
   private LimitConfig limitConfig;

    @GetMapping("/hello")
    public String say() {
//        return "说明： "+ limitConfig.getDescription();
        return "index";
    }

}
