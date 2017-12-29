#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;


import ${package}.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String SayHelloWorld() {
        System.out.println("Hello World~");
        return "执行业务方法的返回值为:Hello World";
    }
}