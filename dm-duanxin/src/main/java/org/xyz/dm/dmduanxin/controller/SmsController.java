package org.xyz.dm.dmduanxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmduanxin.service.DxService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SmsController {


    @Autowired
    private DxService dxService;

    @PostMapping(path = "/yanzhengma")
    private Map<String,Object> yanzhengma(@RequestParam("phone") String phone){
        Boolean boo = dxService.fasong(phone);
        Map<String,Object> map=new HashMap<>();
        map.put("massage",boo);
        return map;
    }

}
