package org.xyz.dm.item.client.fallback;

import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmItemComment;
import org.xyz.dm.item.client.DmItemCommentClient;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:14
 */
@Component
public class DmItemCommentClientFallback implements DmItemCommentClient{
    @Override
    public List<DmItemComment> finbyitemid(Integer bh) {
        return null;
    }
}
