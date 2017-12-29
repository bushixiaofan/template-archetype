#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import com.song.common.idempotent.Idempotent;
import ${package}.model.dto.HelloReq;
import ${package}.service.HelloService;
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
