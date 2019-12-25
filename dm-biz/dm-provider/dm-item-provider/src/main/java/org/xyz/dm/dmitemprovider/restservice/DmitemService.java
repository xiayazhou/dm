package org.xyz.dm.dmitemprovider.restservice;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.repository.DmItemRepository;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DmitemService {

    @Resource
    private DmItemRepository dmItemRepository;

    @PostMapping(path = "/findid")
    public List<DmItem> findid(@RequestParam("itemtypeid") Integer id) {
        return dmItemRepository.findid(id);
    }

    @PostMapping(path = "/findtuijian")
    public List<DmItem> findtuij(){
        return dmItemRepository.findtuijian();
    }

    @PostMapping(path = "/findjjkaishou")
    public List<DmItem> findjjkaishou(){
        return dmItemRepository.findjjkaishou();
    }
    //根据id查询实体
    @GetMapping(path = "/findbh")
    public DmItem findbh(@RequestParam("bh") Integer id){
        return dmItemRepository.findbh(id);
    }
    //不同分类
    @PostMapping(path = "/fenlei")
    public List<DmItem> findfenlei(@RequestParam("id") Integer id){
        return dmItemRepository.findfeilei(id);
    }
    //分组查询一级分类
    @PostMapping(path = "/yijifenlei")
    public List<DmItem> yijifenlei(){
        return dmItemRepository.yijifenlei();
    }
    //查询前五名
    @PostMapping(path = "/qianwuming")
    public List<DmItem> qianwuming(@RequestParam("id") Integer id){
        return dmItemRepository.qianwum(id);
    }

}
