package org.xyz.dm.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.fallback.DmQinziClientFallback;

import java.util.List;

/**
 * 亲自首页。
 */
@FeignClient(name = "dm-item-provider",fallback = DmQinziClientFallback.class)
public interface DmQinziClient {

    //根据热门城市查询热门排行
    @PostMapping(path = "/getQinzi")
    List<DmItem> getQInzi(@RequestParam("areaId") Integer areaId, @RequestParam("limit") Integer limit);

    //根据年龄段查询内容
    @PostMapping(path = "/getage")
    List<DmItem> getage(@RequestParam("age") Integer age,@RequestParam("limit") Integer limit);
}
