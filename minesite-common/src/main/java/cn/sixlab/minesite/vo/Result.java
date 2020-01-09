package cn.sixlab.minesite.vo;

import cn.sixlab.minesite.utils.I18nUtils;
import cn.sixlab.minesite.utils.JsonUtils;

public class Result<T> {

    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = I18nUtils.get(msg);
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
