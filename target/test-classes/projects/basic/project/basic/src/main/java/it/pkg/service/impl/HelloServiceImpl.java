package it.pkg.service.impl;

import it.pkg.aop.annot.HelloAnnotation;
import it.pkg.dao.HelloDao;
import it.pkg.model.bo.Hello;
import it.pkg.model.dto.HelloReq;
import it.pkg.model.dto.HelloRsp;
import it.pkg.service.HelloService;
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
    @Cacheable(value = "defaultCache", key = "#param.q", condition = "#param.q != null ")
    public HelloRsp sayHello(HelloReq param) {
        // TODO Auto-generated method stub
        HelloRsp rsp = new HelloRsp();
        Hello hello = helloDao.getHello(param.getQ());
        String value = "hello," + param.getQ() + ",your ID is：" + hello.getId();
        rsp.setValue(value);
        
        return rsp;
    }
}
