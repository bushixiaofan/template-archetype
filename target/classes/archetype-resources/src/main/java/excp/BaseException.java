#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.excp;


import ${package}.contsts.enums.BaseStatus;

/**
 * @author Auto generated, DO NOT EDIT
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 7209284788425351084L;

    private Integer code;

    private String info;


    public BaseException(BaseStatus baseStatus) {
        super();
        this.code = baseStatus.getCode();
        this.info = baseStatus.getDes();
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

}
