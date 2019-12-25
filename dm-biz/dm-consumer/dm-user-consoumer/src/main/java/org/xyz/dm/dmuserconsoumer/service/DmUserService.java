package org.xyz.dm.dmuserconsoumer.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmUserDto;

public interface DmUserService {
    //登陆
    CommonResponse<DmUserDto> findByPhone(@RequestParam("phone") String phone);
}
