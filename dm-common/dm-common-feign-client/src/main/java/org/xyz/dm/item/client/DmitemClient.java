package org.xyz.dm.item.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.fallback.DmitemClientFallback;

import java.util.List;

@FeignClient(name = "dm-item-provider",fallback = DmitemClientFallback.class)
public interface DmitemClient {

    //
    @PostMapping(path = "/findid")
    List<DmItem> findid(@RequestParam("itemtypeid") Integer id);

    //查询今日推荐
    @PostMapping(path = "/findtuijian")
    List<DmItem> findtuijian();

    //查询即将开售
    @PostMapping(path = "/findjjkaishou")
    List<DmItem> findjjkaishou();

    //根据id查询实体
    @GetMapping(path = "/findbh")
    DmItem findbh(@RequestParam("bh") Integer id);

    //不同分类查询
    @PostMapping(path = "/fenlei")
    List<DmItem> findfenlei(@RequestParam("id") Integer id);

    //分组查询所有的一级分类
    @PostMapping(path = "/yijifenlei")
    List<DmItem> yijifenlei();

    //查询节目的前五名
    @PostMapping(path = "/qianwuming")
    List<DmItem> qianwuming(@RequestParam("id") Integer id);

    //根据id查询详情
    @PostMapping(path = "/shangpinxq")
    DmItem shangpinxq(@RequestParam("bh") Integer bh);

}
