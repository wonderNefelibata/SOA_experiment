package org.csu.soaex2;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
public class ReturnRecordControllerTest {
    public static void main(String[] args) {
        // 创建 RestTemplate 实例
        RestTemplate restTemplate = new RestTemplate();

        // 定义 URL
        String url = "http://localhost:8080/return_records";

        // 获取所有借用记录
        getReturnRecords(restTemplate, url);

        // 根据ID获取借用记录
        String recordId = "3"; // 假设你要查询的借用记录 ID

        // 创建借用记录
        createReturnRecord(restTemplate, url);

        // 更新借用记录
        updateReturnRecord(restTemplate, url, recordId);

    }

    private static void getReturnRecords(RestTemplate restTemplate, String url) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 构造请求实体（仅包含请求头）
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // 使用 RestTemplate 发起 GET 请求
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            // 打印返回的状态码
            System.out.println("Response Status Code: " + response.getStatusCodeValue());

            // 打印返回的响应体
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createReturnRecord(RestTemplate restTemplate, String url) {
        // 构建请求体
        String requestBody = """
            {
              "userId": "user1",
              "bookId": "10007",
              "returnDate": "2024-11-19"
            }
            """;

        // 设置 HTTP 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 创建请求对象
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // 发送 POST 请求
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            System.out.println("Response Status Code: " + response.getStatusCodeValue());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateReturnRecord(RestTemplate restTemplate, String url, String recordId) {
        // 构建请求体
        String requestBody = """
            {
              "userId": "user1",
              "bookId": "10005",
              "returnDate": "2024-11-30"
            }
            """;

        // 设置 HTTP 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 创建请求对象
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // 构建请求URL
        String requestUrl = url + "/" + recordId;

        // 发送 PUT 请求
        try {
            ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.PUT, requestEntity, String.class);
            System.out.println("Response Status Code: " + response.getStatusCodeValue());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
