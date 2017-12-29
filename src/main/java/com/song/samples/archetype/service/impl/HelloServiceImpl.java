package com.song.samples.archetype.service.impl;

import com.song.samples.archetype.aop.annot.HelloAnnotation;
import com.song.samples.archetype.dao.HelloDao;
import com.song.samples.archetype.model.bo.Hello;
import com.song.samples.archetype.model.dto.HelloReq;
import com.song.samples.archetype.model.dto.HelloRsp;
import com.song.samples.archetype.service.HelloService;
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
