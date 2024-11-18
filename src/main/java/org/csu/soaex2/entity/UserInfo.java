package org.csu.soaex2.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * @author lenovo
 */
@Data
@TableName("userinfo")
public class UserInfo {
    @TableId("user_id")
    private String userId;
    @TableField("user_name")
    private String userName;
    @TableField("password")
    private String password;
    @TableField("email")
    private String email;
    @TableField("user_type")
    private String userType;
    @TableField("last_login_time")
    private Date lastLoginTime;
    @TableField("prefer_type")
    private String preferType;
    @TableField("balance")
    private float balance;
    @TableField("borrow_book_num")
    private int borrowBookNum;
    @TableField("search_num")
    private int searchNum;


}
