package org.csu.soaex2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.csu.soaex2.entity.ReturnRecord;

import java.util.List;

public interface ReturnRecordService extends IService<ReturnRecord> {
    // 获取所有归还记录
    List<ReturnRecord> getAllReturnRecords();

    // 根据ID获取归还记录
    ReturnRecord getReturnRecordById(String recordId);

    // 创建新的归还记录
    boolean createReturnRecord(ReturnRecord returnRecord);

    // 更新指定ID的归还记录
    boolean updateReturnRecord(String recordId, ReturnRecord returnRecord);

}
