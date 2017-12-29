package it.pkg.service.impl;


import it.pkg.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String SayHelloWorld() {
        System.out.println("Hello World~");
        return "执行业务方法的返回值为:Hello World";
    }
}