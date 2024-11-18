package org.csu.soaex2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.csu.soaex2.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author lenovo
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
