package org.csu.soaex2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("return_record")
public class ReturnRecord {
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String recordId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "return_date")
    private Date returnDate;
}
