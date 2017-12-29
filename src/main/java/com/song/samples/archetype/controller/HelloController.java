package com.song.samples.archetype.controller;

import com.song.common.idempotent.Idempotent;
import com.song.samples.archetype.model.dto.HelloReq;
import com.song.samples.archetype.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author Auto generated, DO NOT EDIT
 */
@Controller
@RequestMapping("/song")
public class HelloController{

    @Autowired
    private HelloService helloService;
    
    /***
     * 获取hello对象
     * 
     * @return 返回对象详情 
     */
    @RequestMapping(value = "/hello")
    @ResponseBody
    @Idempotent
    public Object hello(@Valid HelloReq param, BindingResult bindingResult) {
        return helloService.sayHello(param);
    }
}
