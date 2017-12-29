#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import com.song.common.utils.JsonUtil;
import ${package}.model.dto.HelloReq;
import ${package}.model.dto.HelloRsp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring.xml")
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;

    @Test
    public void testHello(){
        HelloReq param = new HelloReq();
        param.setQ("q");
        HelloRsp hello = helloService.sayHello(param);
        System.out.println(JsonUtil.toJson(hello));
    }
}