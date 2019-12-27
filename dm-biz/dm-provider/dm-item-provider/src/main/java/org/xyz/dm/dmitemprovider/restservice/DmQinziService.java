package org.xyz.dm.dmitemprovider.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.mapper.DmQinziMapper;

import java.util.List;

@RestController
public class DmQinziService {

    @Autowired
    private DmQinziMapper dmQinziMapper;

    @PostMapping(path = "/getQinzi")
    public List<DmItem> getQinzi(@RequestParam("areaId") Integer areaId, @RequestParam("limit") Integer limit){
//        System.out.println(areaId);
//        System.out.println(limit);
        return dmQinziMapper.getRemen(areaId, limit);
    }
    //根据年龄段查询节目
    @PostMapping(path = "/getage")
    public List<DmItem> getage(@RequestParam("age") Integer age,@RequestParam("limit") Integer limit){
        return dmQinziMapper.nianlin(age, limit);
    }

}
