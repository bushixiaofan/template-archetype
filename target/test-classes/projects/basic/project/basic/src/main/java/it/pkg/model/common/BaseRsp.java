package it.pkg.model.common;

/**
 * @author Auto generated, DO NOT EDIT
 */
public class BaseRsp<T> {

    private BStatus bstatus;
    private T data;

    public BaseRsp() {
        this.bstatus = new BStatus();
        this.data = null;
    }

    public BStatus getBStatus() {
        return bstatus;
    }

    public void setBStatus(BStatus bstatus) {
        this.bstatus = bstatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
