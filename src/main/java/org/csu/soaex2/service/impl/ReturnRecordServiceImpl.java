package org.csu.soaex2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.csu.soaex2.entity.ReturnRecord;
import org.csu.soaex2.mapper.BookInfoMapper;
import org.csu.soaex2.mapper.ReturnRecordMapper;
import org.csu.soaex2.service.ReturnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnRecordServiceImpl extends ServiceImpl<ReturnRecordMapper, ReturnRecord> implements ReturnRecordService {
    @Autowired
    private ReturnRecordMapper returnRecordMapper;
    // 获取所有归还记录
    @Override
    public List<ReturnRecord> getAllReturnRecords() {
        return this.list();
    }

    // 根据ID获取归还记录
    @Override
    public ReturnRecord getReturnRecordById(String recordId) {
        QueryWrapper<ReturnRecord> queryWrapper = new QueryWrapper<ReturnRecord>();
        queryWrapper.eq("record_id", recordId);
        return returnRecordMapper.selectOne(queryWrapper);
    }

    // 创建新的归还记录
    @Override
    public boolean createReturnRecord(ReturnRecord returnRecord) {
        return returnRecordMapper.insert(returnRecord) == 1;
    }

    // 更新指定ID的归还记录
    @Override
    public boolean updateReturnRecord(String recordId, ReturnRecord returnRecord) {
        // 创建QueryWrapper对象
        QueryWrapper<ReturnRecord> queryWrapper = new QueryWrapper<ReturnRecord>();


        // 添加条件，指定更新哪条记录
        queryWrapper.eq("record_id", recordId);

        // 使用update方法，并传入实体对象和条件wrapper
        int updateCount = returnRecordMapper.update(returnRecord, queryWrapper);

        // 如果更新的记录数为1，则返回true，表示更新成功
        return updateCount == 1;
    }

}
