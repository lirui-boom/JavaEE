package cn.boom.domain;

public class MsgBean {
    private boolean flag;
    private Object object;//返回的结果集
    private String errorMsg;

    public MsgBean() {
    }

    public MsgBean(boolean flag, Object object, String errorMsg) {
        this.flag = flag;
        this.object = object;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "MsgBean{" +
                "flag=" + flag +
                ", object=" + object +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
