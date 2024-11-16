package org.csu.soaex2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.csu.soaex2.entity.BorrowRecord;

import java.util.List;

public interface BorrowRecordService extends IService<BorrowRecord> {
    // 获取所有借用记录
    List<BorrowRecord> getAllBorrowRecords();

    // 根据ID获取借用记录
    BorrowRecord getBorrowRecordById(String recordId);

    // 创建新的借用记录
    boolean createBorrowRecord(BorrowRecord borrowRecord);

    // 更新指定ID的借用记录
    boolean updateBorrowRecord(String recordId, BorrowRecord borrowRecord);

    // 删除指定ID的借用记录
    boolean deleteBorrowRecord(String recordId);


}
