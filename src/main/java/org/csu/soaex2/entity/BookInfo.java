package org.csu.soaex2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bookinfo")
public class BookInfo {
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publisher_time")
    private Date publisherTime;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "category")
    private String category;
    @Column(name = "code")
    private String code;
    @Column(name = "price")
    private float price;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "should_return_date")
    private Date shouldReturnDate;
    @Column(name = "borrow_status")
    private String borrowStatus;
    @Column(name = "ebook")
    private String ebook;
    @Column(name = "search_num")
    private int searchNum;


}
