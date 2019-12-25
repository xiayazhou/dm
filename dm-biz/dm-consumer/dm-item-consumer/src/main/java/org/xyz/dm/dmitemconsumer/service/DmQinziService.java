package org.xyz.dm.dmitemconsumer.service;

import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.entity.DmItem;

/**
 * 亲自首页
 */
public interface DmQinziService {

    //根据热门城市查询热门排行
    CommonResponse<DmItem> getQinzi(Integer areaId,Integer limit);

}
