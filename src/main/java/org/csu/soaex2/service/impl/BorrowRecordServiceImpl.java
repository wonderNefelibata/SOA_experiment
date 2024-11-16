package org.csu.soaex2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.csu.soaex2.entity.BorrowRecord;
import org.csu.soaex2.mapper.BorrowRecordMapper;
import org.csu.soaex2.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowRecordServiceImpl extends ServiceImpl<BorrowRecordMapper, BorrowRecord> implements BorrowRecordService {

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;
    // 获取所有借用记录
    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return this.list();
    }

    // 根据ID获取借用记录
    @Override
    public BorrowRecord getBorrowRecordById(String recordId) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<BorrowRecord>();
        queryWrapper.eq("record_id", recordId);
        return borrowRecordMapper.selectOne(queryWrapper);
    }

    // 创建新的借用记录
    @Override
    public boolean createBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordMapper.insert(borrowRecord) == 1;
    }

    // 更新指定ID的借用记录
    @Override
    public boolean updateBorrowRecord(String recordId, BorrowRecord borrowRecord) {
        // 创建QueryWrapper对象
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<BorrowRecord>();

        // 假设recordId是BorrowRecord表的主键
        // 添加条件，指定更新哪条记录
        queryWrapper.eq("record_id", recordId);

        // 使用update方法，并传入实体对象和条件wrapper
        // 这里假设你的BorrowRecordMapper继承了BaseMapper，因此有update方法
        int updateCount = borrowRecordMapper.update(borrowRecord, queryWrapper);

        // 如果更新的记录数为1，则返回true，表示更新成功
        return updateCount == 1;
    }

    // 删除指定ID的借用记录
    @Override
    public boolean deleteBorrowRecord(String recordId) {
        QueryWrapper<BorrowRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("record_id", recordId);
        return borrowRecordMapper.delete(queryWrapper) > 0;
    }
}
