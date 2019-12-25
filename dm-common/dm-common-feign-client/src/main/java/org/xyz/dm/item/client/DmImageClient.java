package org.xyz.dm.item.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.item.client.fallback.DmImageClientFallback;

import java.util.List;

@FeignClient(name = "dm-base-provider",fallback = DmImageClientFallback.class)
public interface DmImageClient {

    //查询轮播图
    @PostMapping(path = "/findlunbo")
    List<DmImage> findlunbo();
    //根据节目id查询图片
    @GetMapping(path = "/findjmid")
    DmImage findjmid(@RequestParam("id")Integer id);
    //查询海报
    @GetMapping(path = "/haibao")
    DmImage haibao(@RequestParam("id") Integer id);
}
