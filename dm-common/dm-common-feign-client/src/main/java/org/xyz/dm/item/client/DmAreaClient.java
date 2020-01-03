package org.xyz.dm.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.xyz.dm.item.client.fallback.DmAreaClientFallback;

@FeignClient(name = "dm-base-provider",fallback = DmAreaClientFallback.class)
public interface DmAreaClient {
    //查询热门城市
}
