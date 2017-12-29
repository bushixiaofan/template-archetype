package com.song.samples.archetype.service.impl;


import com.song.samples.archetype.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String SayHelloWorld() {
        System.out.println("Hello World~");
        return "执行业务方法的返回值为:Hello World";
    }
}