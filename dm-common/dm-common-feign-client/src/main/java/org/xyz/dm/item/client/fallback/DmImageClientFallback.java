package org.xyz.dm.item.client.fallback;

import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.item.client.DmImageClient;

import java.util.List;

@Component
public class DmImageClientFallback implements DmImageClient {
    public List<DmImage> findlunbo() {
        System.out.println("查询轮播图出现异常");
        return null;
    }

    public DmImage findjmid(Integer id) {
        System.out.println("实体类查询出现异常");
        return null;
    }

    public DmImage haibao(Integer id) {
        System.out.println("海报查询失败");
        return null;
    }
}
