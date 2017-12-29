#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.impl;

import ${package}.aop.annot.HelloAnnotation;
import ${package}.dao.HelloDao;
import ${package}.model.bo.Hello;
import ${package}.model.dto.HelloReq;
import ${package}.model.dto.HelloRsp;
import ${package}.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @author Auto generated, DO NOT EDIT
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    @HelloAnnotation(value = 1)
    @Cacheable(value = "defaultCache", key = "${symbol_pound}param.q", condition = "${symbol_pound}param.q != null ")
    public HelloRsp sayHello(HelloReq param) {
        // TODO Auto-generated method stub
        HelloRsp rsp = new HelloRsp();
        Hello hello = helloDao.getHello(param.getQ());
        String value = "hello," + param.getQ() + ",your ID is：" + hello.getId();
        rsp.setValue(value);
        
        return rsp;
    }
}
