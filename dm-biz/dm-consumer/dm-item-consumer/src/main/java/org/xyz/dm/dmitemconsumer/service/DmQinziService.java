package org.xyz.dm.dmitemconsumer.service;

import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmLoucengremenDto;
import org.xyz.dm.entity.DmItem;

import java.util.List;

/**
 * 亲自首页
 */
public interface DmQinziService {

    //根据热门城市查询热门排行
    CommonResponse<List<DmLoucengremenDto>> getQinzi(Integer areaId, Integer limit);

    //根据年龄段查询节目
    CommonResponse<List<DmLoucengremenDto>> gerage(Integer age,Integer limit);

}
