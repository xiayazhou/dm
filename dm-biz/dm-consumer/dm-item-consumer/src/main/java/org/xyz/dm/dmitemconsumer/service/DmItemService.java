package org.xyz.dm.dmitemconsumer.service;

import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmFenleiDto;
import org.xyz.dm.dto.DmItemDto;
import org.xyz.dm.dto.DmLoucengDto;
import org.xyz.dm.entity.DmItem;

import java.util.List;

public interface DmItemService {

    //查询每个主题的的热门节目
    List<DmItem> findid(Integer id);

    CommonResponse<List<DmItemDto>> findtuijian();

    //查询即将开售
    CommonResponse<List<DmItemDto>> findjjkaishou();

    //不同分类查询
    CommonResponse<List<DmFenleiDto>> findfenlei();

    //首页返回不同楼层展示数据
    CommonResponse<List<DmLoucengDto>> loucengfenlei();

}
