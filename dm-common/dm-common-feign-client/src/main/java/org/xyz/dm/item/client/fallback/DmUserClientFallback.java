package org.xyz.dm.item.client.fallback;

import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmUser;
import org.xyz.dm.item.client.DmUserClient;

import java.util.List;

@Component
public class DmUserClientFallback implements DmUserClient {
    public List<DmUser> getAll() {
        return null;
    }

    @Override
    public DmUser findByPhone(String phone) {
        return null;
    }
}
