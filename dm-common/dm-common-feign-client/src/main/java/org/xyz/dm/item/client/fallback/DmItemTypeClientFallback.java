package org.xyz.dm.item.client.fallback;


import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmItemType;
import org.xyz.dm.item.client.DmItemTypeClient;

import java.util.List;

@Component
public class DmItemTypeClientFallback implements DmItemTypeClient {
    public List<DmItemType> findByParent(Integer parent) {
        System.out.println("信息异常");
        return null;
    }


}
