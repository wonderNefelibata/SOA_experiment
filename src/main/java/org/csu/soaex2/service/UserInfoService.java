package org.csu.soaex2.service;

import org.csu.soaex2.common.CommonResponse;

import java.util.Map;

public interface UserInfoService {
    CommonResponse createOneUser(Map map);

    CommonResponse searchOneUser(String userId);

    CommonResponse deleteOneUser(String userId);

    CommonResponse getAllUser();

    CommonResponse updateOneUser(Map map, String userId);
}
