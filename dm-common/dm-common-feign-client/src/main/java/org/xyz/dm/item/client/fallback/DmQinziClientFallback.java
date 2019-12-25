package org.xyz.dm.item.client.fallback;

import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.DmQinziClient;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/23 11:19
 */
@Component
public class DmQinziClientFallback implements DmQinziClient {
    @Override
    public List<DmItem> getQInzi(Integer areaId, Integer limit) {
        return null;
    }
}
