package org.csu.soaex2.common;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CommonResponse<T> extends RepresentationModel<CommonResponse<T>> {

    private int status;
    private String message;
    private T data;

    public CommonResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getstatus() {
        return status;
    }

    public void setstatus(int status) {
        this.status = status;
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

    // 添加 Hypermedia Link
    public void addLinks(List<Link> links) {
        links.forEach(this::add);
    }

    // 返回成功响应
    public static <T> ResponseEntity<CommonResponse<T>> success(T data) {
        CommonResponse<T> response = new CommonResponse<>(HttpStatus.OK.value(), "Success", data);
        // 添加Hypermedia链接
        response.addLinks(List.of(Link.of("/api/next-step").withRel("next-step")));  // 示例链接
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 返回错误响应
    public static <T> ResponseEntity<CommonResponse<T>> error(String message) {
        CommonResponse<T> response = new CommonResponse<>(HttpStatus.BAD_REQUEST.value(), message, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 返回创建响应
    public static <T> ResponseEntity<CommonResponse<T>> created(T data) {
        CommonResponse<T> response = new CommonResponse<>(HttpStatus.CREATED.value(), "Created", data);
        response.addLinks(List.of(Link.of("/api/next-step").withRel("next-step"))); // 示例链接
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
