package org.csu.soaex2.controller;

import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.entity.ReturnRecord;
import org.csu.soaex2.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/return_records")
public class ReturnRecordController {
    @Autowired
    private ReturnRecordService returnRecordService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<ReturnRecord>>> getAllReturnRecords() {
        List<ReturnRecord> records = returnRecordService.list();
        if (records.isEmpty()) {
            return CommonResponse.error("没有找到归还记录");
        } else {
            return CommonResponse.success(records);
        }
    }

    @GetMapping("/{record_id}")
    public ResponseEntity<CommonResponse<ReturnRecord>> getReturnRecordById(@PathVariable String record_id) {
        ReturnRecord record = returnRecordService.getReturnRecordById(record_id);
        if (record == null) {
            return CommonResponse.error("归还记录不存在");
        } else {
            return CommonResponse.success(record);
        }
    }

    @PostMapping
    public ResponseEntity<CommonResponse<ReturnRecord>> createReturnRecord(@RequestBody ReturnRecord returnRecord) {
        boolean success = returnRecordService.createReturnRecord(returnRecord);
        if (success) {
            return CommonResponse.created(returnRecord);
        } else {
            return CommonResponse.error("创建归还记录失败");
        }
    }

    @PutMapping("/{record_id}")
    public ResponseEntity<CommonResponse<ReturnRecord>> updateReturnRecord(@PathVariable String record_id, @RequestBody ReturnRecord ReturnRecord) {
        ReturnRecord.setRecordId(record_id);
        boolean success = returnRecordService.updateReturnRecord(record_id, ReturnRecord);

        if (success) {
            return CommonResponse.success(ReturnRecord);
        } else {
            return CommonResponse.error("更新归还记录失败");
        }
    }

}
