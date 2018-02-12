package cn.cc.ll.dto;

public class result<T> {
    private boolean success;
    private T data;
    private String error;

    public result() {
    }

    // 成功时的构造器
    public result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    // 错误时的构造器
    public result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "result{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
