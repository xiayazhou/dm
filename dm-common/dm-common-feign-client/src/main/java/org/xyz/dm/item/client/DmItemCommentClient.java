package org.xyz.dm.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.entity.DmItemComment;
import org.xyz.dm.item.client.fallback.DmItemCommentClientFallback;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:13
 */
@FeignClient(name = "dm-item-provider",fallback = DmItemCommentClientFallback.class)
public interface DmItemCommentClient {

    //根据id查询信息
    @PostMapping(path = "/findbyitemid")
    List<DmItemComment> finbyitemid(@RequestParam("bh") Integer bh);
}
