package org.xyz.dm.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmCinema;
import org.xyz.dm.item.client.fallback.DmCinemaClientFallback;

@FeignClient(name = "dm-item-provider",fallback = DmCinemaClientFallback.class)
public interface DmCinemaClient {

    //根据id查询城市

    @GetMapping(path = "/chengshi")
    DmCinema findnbh(@RequestParam("bh") Integer id);
}
