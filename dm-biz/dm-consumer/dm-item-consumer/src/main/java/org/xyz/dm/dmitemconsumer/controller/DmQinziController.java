package org.xyz.dm.dmitemconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmitemconsumer.service.DmQinziService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmLoucengDto;
import org.xyz.dm.dto.DmLoucengremenDto;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/26 8:46
 */
@RestController
@RequestMapping(path = "/qinzi")
public class DmQinziController {

    @Autowired
    private DmQinziService dmQinziService;

    //根据热门城市查询热门排行
    @PostMapping(path = "/getall")
    public CommonResponse<List<DmLoucengremenDto>> getall(@RequestParam("areaId") Integer areaId, @RequestParam("limit")Integer limit){
//            System.out.println(areaId);
//            System.out.println(limit);
        return dmQinziService.getQinzi(areaId,limit);
    }
    //根据年龄段查询
    @PostMapping(path = "/getage")
    public CommonResponse<List<DmLoucengremenDto>> getage(@RequestParam("age") Integer age,@RequestParam("limit") Integer limit){
            return dmQinziService.gerage(age, limit);
    }

}
