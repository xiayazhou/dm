package org.xyz.dm.mapper;

import org.xyz.dm.dto.DmLoucengremenDto;
import org.xyz.dm.entity.DmItem;

import java.util.List;

public interface DmQinziMapper {

    //亲子页面。根据热门城市查询热门排行
    List<DmItem> getRemen(Integer areaid, Integer limit);

}
