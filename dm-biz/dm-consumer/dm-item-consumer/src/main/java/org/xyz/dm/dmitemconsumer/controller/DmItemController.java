package org.xyz.dm.dmitemconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmitemconsumer.service.DmItemService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmFenleiDto;
import org.xyz.dm.dto.DmItemDto;
import org.xyz.dm.dto.DmLoucengDto;

import java.util.List;

@RestController

public class DmItemController {

    @Autowired
    private DmItemService  dmItemService;


    //查询今日推荐
    @PostMapping(path = "/findtuijian")
    public CommonResponse<List<DmItemDto>> findtuijian(){
        return dmItemService.findtuijian();
    }

    //查询即将开售
    @PostMapping(path = "/dinfjjkaishou")
    public CommonResponse<List<DmItemDto>> findjjkaishou(){
        return dmItemService.findjjkaishou();
    }

    //查询不同分类的
    @PostMapping(path = "/fenlei")
    public CommonResponse<List<DmFenleiDto>> fenlei(){
        return dmItemService.findfenlei();
    }

    //首页返回不同楼层展示数据
    @PostMapping(path = "/louceng")
    public CommonResponse<List<DmLoucengDto>> louceng(){
        return dmItemService.loucengfenlei();
    }

}
