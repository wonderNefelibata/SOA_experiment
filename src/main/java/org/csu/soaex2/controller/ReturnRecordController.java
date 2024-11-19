package org.csu.soaex2.controller;

import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.entity.ReturnRecord;
import org.csu.soaex2.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/return_records")
public class ReturnRecordController {
    @Autowired
    private ReturnRecordService returnRecordService;

    @GetMapping
    public CommonResponse<List<ReturnRecord>> getAllReturnRecords() {
        List<ReturnRecord> records = returnRecordService.list();
        if (records.isEmpty()) {
            return CommonResponse.error(404,"没有找到归还记录");
        } else {
            CommonResponse<List<ReturnRecord>> response = CommonResponse.success(records);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(ReturnRecordController.class).getAllReturnRecords()).withSelfRel();
            Link createLink = linkTo(methodOn(ReturnRecordController.class).createReturnRecord(null)).withRel("create");
            Link nextStepLink = linkTo(methodOn(ReturnRecordController.class).getAllReturnRecords()).withRel("next-step");
            response.addLinks(List.of(selfLink, createLink, nextStepLink));
            return response;
        }
    }

    @GetMapping("/{record_id}")
    public CommonResponse<ReturnRecord> getReturnRecordById(@PathVariable String record_id) {
        ReturnRecord record = returnRecordService.getReturnRecordById(record_id);
        if (record == null) {
            return CommonResponse.error(404,"归还记录不存在");
        } else {
            CommonResponse<ReturnRecord> response = CommonResponse.success(record);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(ReturnRecordController.class).getReturnRecordById(record_id)).withSelfRel();
            Link listLink = linkTo(methodOn(ReturnRecordController.class).getAllReturnRecords()).withRel("list");
            Link updateLink = linkTo(methodOn(ReturnRecordController.class).updateReturnRecord(record_id, null)).withRel("update");
            response.addLinks(List.of(selfLink, listLink, updateLink));
            return response;
        }
    }

    @PostMapping
    public CommonResponse<ReturnRecord> createReturnRecord(@RequestBody ReturnRecord returnRecord) {
        boolean success = returnRecordService.createReturnRecord(returnRecord);
        if (success) {
            CommonResponse<ReturnRecord> response = CommonResponse.success(returnRecord);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(ReturnRecordController.class).createReturnRecord(null)).withSelfRel();
            Link listLink = linkTo(methodOn(ReturnRecordController.class).getAllReturnRecords()).withRel("list");
            Link nextStepLink = linkTo(methodOn(ReturnRecordController.class).getReturnRecordById(returnRecord.getRecordId())).withRel("next-step");
            response.addLinks(List.of(selfLink, listLink, nextStepLink));
            return response;
        } else {
            return CommonResponse.error(500,"创建归还记录失败");
        }
    }

    @PutMapping("/{record_id}")
    public CommonResponse<ReturnRecord> updateReturnRecord(@PathVariable String record_id, @RequestBody ReturnRecord returnRecord) {
        returnRecord.setRecordId(record_id);
        boolean success = returnRecordService.updateReturnRecord(record_id, returnRecord);

        if (success) {
            CommonResponse<ReturnRecord> response = CommonResponse.success(returnRecord);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(ReturnRecordController.class).updateReturnRecord(record_id, null)).withSelfRel();
            Link listLink = linkTo(methodOn(ReturnRecordController.class).getAllReturnRecords()).withRel("list");
            Link nextStepLink = linkTo(methodOn(ReturnRecordController.class).getReturnRecordById(record_id)).withRel("next-step");
            response.addLinks(List.of(selfLink, listLink, nextStepLink));
            return response;
        } else {
            return CommonResponse.error(500,"更新归还记录失败");
        }
    }

}
