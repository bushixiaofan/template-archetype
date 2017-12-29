#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.model.bo.Hello;
import org.springframework.stereotype.Repository;

/**
 * @author Auto generated, DO NOT EDIT
 */
@Repository
public interface HelloDao {

    Hello getHello(String q);
}
