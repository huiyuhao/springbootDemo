package com.huiyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Controller + @ResponseBody = @RestController
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired
   private LimitConfig limitConfig;

//    @GetMapping("/say/{id}")
//    @PostMapping("/say")
//    @RequestMapping("/say")
//    @GetMapping("/say")
    @PostMapping("/say")
//    public String say(@PathVariable("id") Integer id) {
//    public String say(@RequestParam("id") Integer id) {
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
//        return "说明： "+ limitConfig.getDescription();
//        return "index";
        return "id:" + id;
    }

}
