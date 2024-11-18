package org.csu.soaex2.controller;

import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.entity.BorrowRecord;
import org.csu.soaex2.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow_records")
public class BorrowRecordController {

//    @Autowired
//    private BorrowRecordService borrowRecordService;
//
//    @GetMapping
//    public ResponseEntity<CommonResponse<List<BorrowRecord>>> getAllBorrowRecords() {
//        List<BorrowRecord> records = borrowRecordService.list();
//        if (records.isEmpty()) {
//            return CommonResponse.error("没有找到借用记录");
//        } else {
//            return CommonResponse.success(records);
//        }
//    }
//
//    @GetMapping("/{record_id}")
//    public ResponseEntity<CommonResponse<BorrowRecord>> getBorrowRecordById(@PathVariable String record_id) {
//        BorrowRecord record = borrowRecordService.getBorrowRecordById(record_id);
//        if (record == null) {
//            return CommonResponse.error("借用记录不存在");
//        } else {
//            return CommonResponse.success(record);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<CommonResponse<BorrowRecord>> createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
//        boolean success = borrowRecordService.createBorrowRecord(borrowRecord);
//        if (success) {
//            return CommonResponse.created(borrowRecord);
//        } else {
//            return CommonResponse.error("创建借用记录失败");
//        }
//    }
//
//    @PutMapping("/{record_id}")
//    public ResponseEntity<CommonResponse<BorrowRecord>> updateBorrowRecord(@PathVariable String record_id, @RequestBody BorrowRecord borrowRecord) {
//        borrowRecord.setRecordId(record_id);
//        boolean success = borrowRecordService.updateBorrowRecord(record_id, borrowRecord);
//
//        if (success) {
//            return CommonResponse.success(borrowRecord);
//        } else {
//            return CommonResponse.error("更新借用记录失败");
//        }
//    }
//
//    @DeleteMapping("/{record_id}")
//    public ResponseEntity<CommonResponse<String>> deleteBorrowRecord(@PathVariable String record_id) {
//        boolean success = borrowRecordService.deleteBorrowRecord(record_id);
//        if (success) {
//            return CommonResponse.success("删除借用记录成功");
//        } else {
//            return CommonResponse.error("删除借用记录失败");
//        }
//    }
}