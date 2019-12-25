package org.xyz.dm.dmitemconsumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmitemconsumer.service.DmItemTypeService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmItemDto;
import org.xyz.dm.dto.DmItemTypeDto;
import org.xyz.dm.entity.DmItemType;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class DmItemTypeController {

    @Autowired
    private DmItemTypeService dmItemTypeService;

    @PostMapping(path = "/findByParent")
    public CommonResponse<List<DmItemTypeDto>> queryAllType(){
        return dmItemTypeService.queryAllType();
    }

    //查询
    @PostMapping(path = "/findid")
    public CommonResponse<List<DmItemTypeDto>> findid(){
        return dmItemTypeService.finddaoh();
    }

    //查询二级导航
    @PostMapping(path = "/hengx")
    public CommonResponse<List<DmItemTypeDto>> findhengx(){
        return dmItemTypeService.findyiji();
    }

//    //查询当日推荐
//    public CommonResponse<List<DmItemDto>> findtuijian(){
//        return dmItemTypeService.
//    }
}
