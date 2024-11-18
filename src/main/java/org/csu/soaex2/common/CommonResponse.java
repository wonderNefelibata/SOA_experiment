package org.csu.soaex2.common;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class CommonResponse<T> extends RepresentationModel<CommonResponse<T>> {

    private int statusCode; // HTTP 状态码
    private String message; // 响应信息
    private T data; // 响应数据

    // 私有构造方法，防止外部直接实例化
    protected CommonResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    // Getters 和 Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 添加超媒体链接
    public void addLinks(List<Link> links) {
        links.forEach(this::add);
    }

    // ============ 静态工厂方法 ============

    /**
     * 成功响应 (无数据)
     */
    public static <T> CommonResponse<T> success() {
        return new CommonResponse<>(200, "Success", null);
    }

    /**
     * 成功响应 (带数据)
     */
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "Success", data);
    }

    /**
     * 成功响应 (带数据和自定义消息)
     */
    public static <T> CommonResponse<T> success(String message, T data) {
        return new CommonResponse<>(200, message, data);
    }

    /**
     * 错误响应
     */
    public static <T> CommonResponse<T> error(int statusCode, String message) {
        return new CommonResponse<>(statusCode, message, null);
    }

    /**
     * 错误响应 (带数据)
     */
    public static <T> CommonResponse<T> error(int statusCode, String message, T data) {
        return new CommonResponse<>(statusCode, message, data);
    }
}