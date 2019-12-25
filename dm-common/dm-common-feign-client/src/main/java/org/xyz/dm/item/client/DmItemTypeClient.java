package org.xyz.dm.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmItemType;
import org.xyz.dm.item.client.fallback.DmItemTypeClientFallback;

import java.util.List;

@FeignClient(name = "dm-item-provider",fallback = DmItemTypeClientFallback.class)
public interface DmItemTypeClient {
    @PostMapping(path = "/findByParent")
    List<DmItemType> findByParent(@RequestParam("parent") Integer parent);


}
