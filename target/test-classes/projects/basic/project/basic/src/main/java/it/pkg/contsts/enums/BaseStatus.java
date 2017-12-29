package it.pkg.contsts.enums;

/**
 * @author Auto generated, DO NOT EDIT
 */
public enum BaseStatus {
    SUCCESS(0, "成功"),// 正常
    UNKNOWN_ERROR(1, "系统错误"), // 系统错误
    PARAM_ERROR(2, "参数错误"), // 参数错误
    ;
    
    private int code = 0;
    private String des = "成功";
    
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

    BaseStatus(int code, String des) {
        this.code = code;
        this.des = des;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("_").append(code).append("_").append(des);
        return sb.toString();
    }

}
