package org.xyz.dm.dmitemconsumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmitemconsumer.service.DmQinziService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.entity.DmCinema;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.DmCinemaClient;
import org.xyz.dm.item.client.DmImageClient;
import org.xyz.dm.item.client.DmQinziClient;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/23 12:03
 */
@Service
public class DmQinziServiceImpl implements DmQinziService {


    @Autowired
    private DmQinziClient dmQinziClient;

    @Autowired
    private DmImageClient dmImageClient;

    @Autowired
    private DmCinemaClient dmCinemaClient;


    @Override
    public CommonResponse<DmItem> getQinzi(Integer areaId, Integer limit) {
        //根据城市编号查询信息
        List<DmItem> qInzi = dmQinziClient.getQInzi(areaId, limit);
        //查询出对应的城市
        DmCinema findnbh = dmCinemaClient.findnbh(areaId);
        return null;
    }
}
