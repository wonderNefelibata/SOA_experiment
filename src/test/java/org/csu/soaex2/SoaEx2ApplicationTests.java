package org.csu.soaex2;

import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.controller.BookInfoController;
import org.csu.soaex2.mapper.BookInfoMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class SoaEx2ApplicationTests {

    @Test
    void contextLoads() {
        CommonResponse<Object> response = CommonResponse.success();

    }

    @Test
    void testDB(){
        BookInfoMapper mapper;
    }

    @Test
    void simulate() throws IOException {
        StringBuilder response = new StringBuilder();

        String requestUrl = "http://localhost:8080/bookinfo/10001";

        // 创建URL对象
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置请求方法为GET
        connection.setRequestMethod("GET");

        // 设置请求头
        connection.setRequestProperty("Accept", "application/json");

        // 读取响应
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // 关闭连接
        connection.disconnect();
        System.out.println(response.toString());
    }

}
