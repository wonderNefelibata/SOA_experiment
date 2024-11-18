package org.csu.soaex2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author lenovo
 */
@MapperScan("org.csu.soaex2.mapper")
@SpringBootApplication
public class SoaEx2Application {

    public static void main(String[] args) {
        SpringApplication.run(SoaEx2Application.class, args);
    }

}
