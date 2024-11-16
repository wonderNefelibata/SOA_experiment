package org.csu.soaex2.entity;
import jakarta.persistence.*;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("borrow_record")
public class BorrowRecord {
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String recordId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "book_id")
    private String bookId;
    @Column(name = "borrow_date")
    private Date borrowDate;
    @Column(name = "due_date")
    private Date dueDate;


}
