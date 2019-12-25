package org.xyz.dm.dmbaseprovider.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.repository.DmImageRepository;

import java.util.List;

@RestController
public class DmImageService {

    @Autowired
    private DmImageRepository dmImageRepository;

    //查询轮播图
    @PostMapping(path = "/findlunbo")
    public List<DmImage> fidnlunbo(){
        return dmImageRepository.findlunbo();
    }
    //根据节目id查询实体
    @GetMapping(path = "/findjmid")
    public DmImage findjmid(@RequestParam("id") Integer id){
        return dmImageRepository.findjmid(id);
    }
    @GetMapping(path = "/haibao")
    public DmImage haibao(@RequestParam("id") Integer id){
        return dmImageRepository.haibao(id);
    }

}
