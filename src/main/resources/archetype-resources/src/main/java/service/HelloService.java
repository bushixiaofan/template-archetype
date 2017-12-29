#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.model.dto.HelloReq;
import ${package}.model.dto.HelloRsp;

/**
 * @author Auto generated, DO NOT EDIT
 */
public interface HelloService {

    /**
     * @param param
     * @return
     */
    HelloRsp sayHello(HelloReq param);

}
