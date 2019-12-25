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
        return dmQinziMapper.getRemen(areaId, limit);
    }

}
