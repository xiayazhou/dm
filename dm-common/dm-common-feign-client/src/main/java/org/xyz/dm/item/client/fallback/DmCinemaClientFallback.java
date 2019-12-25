package org.xyz.dm.item.client.fallback;


import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmCinema;
import org.xyz.dm.item.client.DmCinemaClient;

@Component
public class DmCinemaClientFallback implements DmCinemaClient {
    public DmCinema findnbh(Integer id) {
        System.out.println("城市查询出现错误");
        return null;
    }
}
