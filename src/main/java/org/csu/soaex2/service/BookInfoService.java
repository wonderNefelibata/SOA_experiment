package org.csu.soaex2.service;

import org.csu.soaex2.entity.BookInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookInfoService {
    List getAllBookInfo();

    Boolean createBookInfo(BookInfo bookInfo);

    Boolean updateBookInfo(String bookID, BookInfo bookInfo);

    Boolean deleteBookInfo(String bookId);

    BookInfo getBookInfoById(String bookId);
}
