package org.xyz.dm.dmuserconsoumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.xyz.dm.dmduanxin.service.DxService;
import org.xyz.dm.dmuserconsoumer.service.DmUserService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmUserDto;

import java.util.Map;

@RestController
public class DmUserController {

    @Autowired
    private DmUserService dmUserService;
//
//    @Autowired
//    private DxService dxService;


    //登陆
    @PostMapping(path = "/findphone")
    private CommonResponse<DmUserDto> findbyphone(@RequestParam("phone") String phone){
        return dmUserService.findByPhone(phone);
    }
//    //发送验证码
//    @PostMapping(path = "/yanzhengma")
//    private Boolean yanzhengma(@RequestParam("phone")String phone){
//        return dxService.fasong(phone);
//    }

}
