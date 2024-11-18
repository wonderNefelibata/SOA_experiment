package org.csu.soaex2.controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class UserInfoControllerDiaoyong {


        public static void main(String[] args) {
//            创建用户接口调用
//            String url = "http://localhost:8080/users";
//
//            // 创建 RestTemplate 实例
//            RestTemplate restTemplate = new RestTemplate();
//
//            // 构建请求体
//            String requestBody = """
//        {
//          "user_id": "12345",
//          "password": "password123",
//          "email": "example@example.com",
//          "user_type": "reader",
//          "prefer_type": "fiction",
//          "balance": "100.50",
//          "user_name": "John Doe",
//          "borrow_book_num": 2,
//          "search_num": 5
//        }
//        """;
//
//            // 设置 HTTP 请求头
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
//
//            // 创建请求对象
//            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
//
//            // 发送 POST 请求
//            try {
//                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//                System.out.println("Response Status Code: " + response.getStatusCodeValue());
//                System.out.println("Response Body: " + response.getBody());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
    //        查询指定用户的信息
            // 基础 URL 和路径参数
//            String url = "http://localhost:8080/users/{user_id}";
//            String userId = "1"; // 假设你要查询的用户 ID
//
//            // 创建 RestTemplate 实例
//            RestTemplate restTemplate = new RestTemplate();
//
//            // 设置请求头
//            HttpHeaders headers = new HttpHeaders();
//            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
//
//            // 创建请求实体
//            // 不需要请求体，只需要设置请求头
//            org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);
//
//            try {
//                // 使用 RestTemplate 的 exchange 方法发送 GET 请求
//                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, userId);
//
//                // 打印返回的状态码和响应体
//                System.out.println("Response Status Code: " + response.getStatusCodeValue());
//                System.out.println("Response Body: " + response.getBody());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            删除指定用户信息
//            DELETE 请求的 URL 和路径参数
//                String url = "http://localhost:8080/users/{user_id}";
//                String userId = "12345"; // 假设你要删除的用户 ID
//
//                // 创建 RestTemplate 实例
//                RestTemplate restTemplate = new RestTemplate();
//
//                // 设置请求头
//                HttpHeaders headers = new HttpHeaders();
//                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
//
//                // 构建请求实体（DELETE 通常不需要请求体，但可以包含请求头）
//                org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);
//
//                try {
//                        // 发送 DELETE 请求
//                        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class, userId);
//
//                        // 打印返回的状态码
//                        System.out.println("Response Status Code: " + response.getStatusCodeValue());
//                        System.out.println("Response Body: " + response.getBody());
//                } catch (Exception e) {
//                        e.printStackTrace();
//                }
                // 定义 URL
//                String url = "http://localhost:8080/users";
//
//                // 创建 RestTemplate 实例
//                RestTemplate restTemplate = new RestTemplate();
//
//                // 设置请求头
//                HttpHeaders headers = new HttpHeaders();
//                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
//
//                // 构造请求实体（仅包含请求头）
//                org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);
//
//                try {
//                        // 使用 RestTemplate 发起 GET 请求
//                        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//
//                        // 打印返回的状态码
//                        System.out.println("Response Status Code: " + response.getStatusCodeValue());
//
//                        // 打印返回的响应体
//                        System.out.println("Response Body: " + response.getBody());
//                } catch (Exception e) {
//                        e.printStackTrace();
//                }
                // PUT 请求的 URL 和路径参数
//                String url = "http://localhost:8080/users/{user_id}";
//                String userId = "71"; // 替换为需要更新的用户 ID
//
//                // 创建 RestTemplate 实例
//                RestTemplate restTemplate = new RestTemplate();
//
//                // 设置请求头
//                HttpHeaders headers = new HttpHeaders();
//                headers.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON));
//                headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); // 设置请求体为 JSON
//
//            // 构建请求体
//            String requestBody = """
//        {
//          "password": "password123",
//          "email": "example@example.com",
//          "user_type": "reader",
//          "prefer_type": "fiction",
//          "balance": "100.50",
//          "user_name": "John Doe",
//          "borrow_book_num": 2,
//          "search_num": 5
//        }
//        """;
//
//
//                // 构建 HttpEntity
//                HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//                try {
//                        // 使用 exchange 方法发送 PUT 请求
//                        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class, userId);
//
//                        // 打印返回的状态码
//                        System.out.println("Response Status Code: " + response.getStatusCodeValue());
//
//                        // 打印返回的响应体
//                        System.out.println("Response Body: " + response.getBody());
//                } catch (Exception e) {
//                        e.printStackTrace();
//                }


        }



}
