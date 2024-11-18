package org.csu.soaex2.controller;

import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.entity.BorrowRecord;
import org.csu.soaex2.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping("/borrow_records")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping
    public CommonResponse<List<BorrowRecord>> getAllBorrowRecords() {
        List<BorrowRecord> records = borrowRecordService.list();
        if (records.isEmpty()) {
            return CommonResponse.error(404, "没有找到借用记录");
        } else {
            CommonResponse<List<BorrowRecord>> response = CommonResponse.success(records);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(BorrowRecordController.class).getAllBorrowRecords()).withSelfRel();
            Link createLink = linkTo(methodOn(BorrowRecordController.class).createBorrowRecord(null)).withRel("create");
            Link nextStepLink = linkTo(methodOn(BorrowRecordController.class).getAllBorrowRecords()).withRel("next-step");
            response.addLinks(List.of(selfLink, createLink, nextStepLink));
            return response;
        }
    }

    @GetMapping("/{record_id}")
    public CommonResponse<BorrowRecord> getBorrowRecordById(@PathVariable String record_id) {
        BorrowRecord record = borrowRecordService.getBorrowRecordById(record_id);
        if (record == null) {
            return CommonResponse.error(404, "借用记录不存在");
        } else {
            CommonResponse<BorrowRecord> response = CommonResponse.success(record);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(BorrowRecordController.class).getBorrowRecordById(record_id)).withSelfRel();
            Link listLink = linkTo(methodOn(BorrowRecordController.class).getAllBorrowRecords()).withRel("list");
            Link updateLink = linkTo(methodOn(BorrowRecordController.class).updateBorrowRecord(record_id, null)).withRel("update");
            Link deleteLink = linkTo(methodOn(BorrowRecordController.class).deleteBorrowRecord(record_id)).withRel("delete");
            response.addLinks(List.of(selfLink, listLink, updateLink, deleteLink));
            return response;
        }
    }

    @PostMapping
    public CommonResponse<BorrowRecord> createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        boolean success = borrowRecordService.createBorrowRecord(borrowRecord);
        if (success) {
            CommonResponse<BorrowRecord> response = CommonResponse.success(borrowRecord);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(BorrowRecordController.class).createBorrowRecord(null)).withSelfRel();
            Link listLink = linkTo(methodOn(BorrowRecordController.class).getAllBorrowRecords()).withRel("list");
            Link nextStepLink = linkTo(methodOn(BorrowRecordController.class).getBorrowRecordById(borrowRecord.getRecordId())).withRel("next-step");
            response.addLinks(List.of(selfLink, listLink, nextStepLink));
            return response;
        } else {
            return CommonResponse.error(500, "创建借用记录失败");
        }
    }

    @PutMapping("/{record_id}")
    public CommonResponse<BorrowRecord> updateBorrowRecord(@PathVariable String record_id, @RequestBody BorrowRecord borrowRecord) {
        borrowRecord.setRecordId(record_id);
        boolean success = borrowRecordService.updateBorrowRecord(record_id, borrowRecord);

        if (success) {
            CommonResponse<BorrowRecord> response = CommonResponse.success(borrowRecord);
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(BorrowRecordController.class).updateBorrowRecord(record_id, null)).withSelfRel();
            Link listLink = linkTo(methodOn(BorrowRecordController.class).getAllBorrowRecords()).withRel("list");
            Link nextStepLink = linkTo(methodOn(BorrowRecordController.class).getBorrowRecordById(record_id)).withRel("next-step");
            response.addLinks(List.of(selfLink, listLink, nextStepLink));
            return response;
        } else {
            return CommonResponse.error(500, "更新借用记录失败");
        }
    }

    @DeleteMapping("/{record_id}")
    public CommonResponse<String> deleteBorrowRecord(@PathVariable String record_id) {
        boolean success = borrowRecordService.deleteBorrowRecord(record_id);
        if (success) {
            CommonResponse<String> response = CommonResponse.success("删除借用记录成功");
            // 添加超媒体链接
            Link selfLink = linkTo(methodOn(BorrowRecordController.class).deleteBorrowRecord(record_id)).withSelfRel();
            Link listLink = linkTo(methodOn(BorrowRecordController.class).getAllBorrowRecords()).withRel("list");
            response.addLinks(List.of(selfLink, listLink));
            return response;
        } else {
            return CommonResponse.error(500, "删除借用记录失败");
        }
    }
}