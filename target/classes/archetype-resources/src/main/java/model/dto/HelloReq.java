#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author Auto generated, DO NOT EDIT
 */
public class HelloReq implements Serializable{

    /**查询关键字*/
    @NotEmpty
    private String q;

    private int address;
    
    /**
     * @return the address
     */
    public int getAddress() {
        return address;
    }

    
    /**
     * @param address the address to set
     */
    public void setAddress(int address) {
        this.address = address;
    }

    /**
     * @return the id
     */
    public String getQ() {
        return q;
    }

    /**
     * @param id the id to set
     */
    public void setQ(String q) {
        this.q = q;
    }
}
