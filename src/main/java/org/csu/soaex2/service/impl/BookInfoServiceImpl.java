package org.csu.soaex2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.soaex2.entity.BookInfo;
import org.csu.soaex2.entity.BorrowRecord;
import org.csu.soaex2.mapper.BookInfoMapper;
import org.csu.soaex2.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    private BookInfoMapper mapper;
    @Override
    public List getAllBookInfo() {
        return mapper.selectList(null);
    }

    @Override
    public Boolean createBookInfo(BookInfo bookInfo) {
        return mapper.insert(bookInfo) == 1;
    }

    @Override
    public Boolean updateBookInfo(String bookId, BookInfo bookInfo) {
        QueryWrapper<BookInfo> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("book_id", bookId);

        int updateCount = mapper.update(bookInfo, queryWrapper);

        // 如果更新的记录数为1，则返回true，表示更新成功
        return updateCount == 1;
    }

    @Override
    public Boolean deleteBookInfo(String bookId) {
        QueryWrapper<BookInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        return mapper.delete(queryWrapper) > 0;
    }

    @Override
    public BookInfo getBookInfoById(String bookId) {
        QueryWrapper<BookInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        return mapper.selectOne(queryWrapper);
    }
}
