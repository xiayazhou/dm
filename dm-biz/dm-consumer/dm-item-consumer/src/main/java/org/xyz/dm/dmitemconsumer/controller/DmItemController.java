package org.xyz.dm.dmitemconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmitemconsumer.service.DmItemService;
import org.xyz.dm.dto.*;

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
    //查询每个主题的热门节目
    @PostMapping(path = "/remen{itemTypeId}")
    public CommonResponse<List<ButongTuijianDto>> remen(@PathVariable("itemTypeId") Integer id){
        System.out.println("热门主题id"+id);
        return dmItemService.findid(id);
    }
    //根据id查询商品
    @PostMapping(path = "/shangpinxq")
    public CommonResponse<JiemuXq> shangpinxq(@RequestParam("bh") Integer bh){
        return dmItemService.shangpinxq(bh);
    }

}
