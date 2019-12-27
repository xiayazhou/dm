package org.xyz.dm.dmitemconsumer.service;

import org.xyz.dm.dto.*;
import org.xyz.dm.entity.DmItem;

import java.util.List;

public interface DmItemService {

    //查询每个主题的的热门节目
    CommonResponse<List<ButongTuijianDto>> findid(Integer id);

    CommonResponse<List<DmItemDto>> findtuijian();

    //查询即将开售
    CommonResponse<List<DmItemDto>> findjjkaishou();

    //不同分类查询
    CommonResponse<List<DmFenleiDto>> findfenlei();

    //首页返回不同楼层展示数据
    CommonResponse<List<DmLoucengDto>> loucengfenlei();

    //根据id查询商品信息
    CommonResponse<JiemuXq> shangpinxq(Integer bh);

}
