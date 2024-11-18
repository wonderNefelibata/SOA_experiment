package org.csu.soaex2;

import org.csu.soaex2.common.CommonResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SoaEx2ApplicationTests {

    @Test
    void contextLoads() {
        CommonResponse<Object> response = CommonResponse.success();

    }

}
