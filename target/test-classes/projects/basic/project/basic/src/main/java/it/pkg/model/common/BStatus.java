package it.pkg.model.common;

import it.pkg.contsts.enums.BaseStatus;

/**
 * @author Auto generated, DO NOT EDIT
 */
public class BStatus {
	int code = 0;
	String des = "";

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
    public void setBStatus(BaseStatus baseStatus) {
        this.code = baseStatus.getCode();
        this.des = baseStatus.getDes();
    }
}
