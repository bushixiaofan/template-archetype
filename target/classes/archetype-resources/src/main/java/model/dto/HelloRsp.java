#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto;

import java.io.Serializable;

/**
 * @author Auto generated, DO NOT EDIT
 */
public class HelloRsp implements Serializable{

    /**学校信息*/
    private String value;

    /**
     * @return the id
     */
    public String getValue() {
        return value;
    }

    /**
     * @param id the id to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
