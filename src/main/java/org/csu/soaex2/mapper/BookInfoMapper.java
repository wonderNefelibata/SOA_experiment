package org.csu.soaex2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.csu.soaex2.entity.BookInfo;

@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {
}
