package org.xyz.dm.item.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmUser;
import org.xyz.dm.item.client.fallback.DmUserClientFallback;

import java.util.List;

@FeignClient(name = "dm-user-provider",fallback = DmUserClientFallback.class)
public interface DmUserClient {

    @PostMapping(path = "getAll")
    List<DmUser> getAll();
    //用户登陆
    @PostMapping(path = "/findByPhone")
    DmUser findByPhone(@RequestParam("phone") String phone);
}
