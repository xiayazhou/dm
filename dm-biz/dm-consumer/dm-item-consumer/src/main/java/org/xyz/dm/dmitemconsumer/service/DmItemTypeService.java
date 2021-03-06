package org.xyz.dm.dmitemconsumer.service;

import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmDaohangDto;
import org.xyz.dm.dto.DmItemTypeDto;
import org.xyz.dm.entity.DmItemType;
import org.xyz.dm.item.client.DmitemClient;

import java.util.List;

public interface DmItemTypeService {

    CommonResponse<List<DmItemTypeDto>> queryAllType();

    CommonResponse<List<DmItemTypeDto>> finddaoh();

    CommonResponse<List<DmItemTypeDto>> findyiji();
    //查询横向导航
    CommonResponse<List<DmDaohangDto>> yiji();

    //今日推荐
//    CommonResponse<List<DmItemType>>
}
