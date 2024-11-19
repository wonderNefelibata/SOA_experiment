package org.csu.soaex2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.entity.UserInfo;
import org.csu.soaex2.mapper.UserInfoMapper;
import org.csu.soaex2.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UserInfoServiceImpl  implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public CommonResponse createOneUser(Map map) {

            UserInfo userInfo=new UserInfo();
            userInfo.setBalance(Float.parseFloat((String) map.get("balance")));
            userInfo.setEmail((String) map.get("email"));
            userInfo.setUserType((String) map.get("user_type"));
            userInfo.setUserName((String) map.get("user_name"));
            userInfo.setPassword((String) map.get("password"));
            userInfo.setPreferType((String) map.get("prefer_type"));
            userInfo.setSearchNum((Integer) map.get("search_num"));
            userInfo.setUserId((String) map.get("user_id"));
            userInfo.setLastLoginTime(new Date());
            userInfo.setBorrowBookNum((Integer) map.get("borrow_book_num"));
            String user_id= (String) map.get("user_id");
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",user_id);
        UserInfo userInfo1=userInfoMapper.selectOne(queryWrapper);

        if(userInfo1!=null){
            return CommonResponse.error(500,"已经存在对应用户信息");
        }
        else {
            userInfoMapper.insert(userInfo);
            return CommonResponse.success();
        }



    }

    @Override
    public CommonResponse searchOneUser(String userId) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        UserInfo userInfo=userInfoMapper.selectOne(queryWrapper);

        if(userInfo!=null){
            return CommonResponse.success(userInfo);
        }
        else {
            return CommonResponse.error(404,"没有对应的用户信息");
        }
    }

    @Override
    public CommonResponse deleteOneUser(String userId) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        UserInfo userInfo=userInfoMapper.selectOne(queryWrapper);

        if(userInfo!=null){
            userInfoMapper.delete(queryWrapper);
            return CommonResponse.success();
        }
        else {
            return CommonResponse.error(404,"没有对应的用户信息，删除失败");
        }
    }

    @Override
    public CommonResponse getAllUser() {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        return CommonResponse.success(userInfoMapper.selectList(queryWrapper));
    }

    @Override
    public CommonResponse updateOneUser(Map map, String userId) {
        UserInfo userInfo=new UserInfo();
        userInfo.setBalance(Float.parseFloat((String) map.get("balance")));
        userInfo.setEmail((String) map.get("email"));
        userInfo.setUserType((String) map.get("user_type"));
        userInfo.setUserName((String) map.get("user_name"));
        userInfo.setPassword((String) map.get("password"));
        userInfo.setPreferType((String) map.get("prefer_type"));
        userInfo.setSearchNum((Integer) map.get("search_num"));
        userInfo.setUserId(userId);
        userInfo.setLastLoginTime(new Date());
        userInfo.setBorrowBookNum((Integer) map.get("borrow_book_num"));

        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        UserInfo userInfo1=userInfoMapper.selectOne(queryWrapper);

        if(userInfo1!=null){
            userInfoMapper.updateById(userInfo);
            return CommonResponse.success();
        }
        else {
            return CommonResponse.error(404,"没有对应的用户信息,更新失败");
        }

    }
}
