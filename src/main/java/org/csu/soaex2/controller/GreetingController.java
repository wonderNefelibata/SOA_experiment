package org.csu.soaex2.controller;

import org.csu.soaex2.common.CommonResponse;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GreetingController {
    @GetMapping("/api/example")
    public CommonResponse exampleApi() {
        // 创建响应数据
        String data = "This is an example response";

        // 创建 CommonResponse 对象
        CommonResponse response = CommonResponse.success(data);

        // 添加超媒体链接
        Link selfLink = linkTo(methodOn(GreetingController.class).exampleApi()).withSelfRel(); // 当前 API 的链接

        Link nextStepLink = Link.of("/api/next-step").withRel("next-step"); // 自定义的下一步链接

        response.addLinks(List.of(selfLink, nextStepLink));

        return response;
    }
}
