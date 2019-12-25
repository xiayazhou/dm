package org.xyz.dm.dmbaseconsoumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmbaseconsoumer.service.DmimageService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmimagesDto;
import org.xyz.dm.dto.DtoUtil;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.DmImageClient;
import org.xyz.dm.item.client.DmitemClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmimageServiceImpl implements DmimageService {

    @Autowired
    private DmImageClient dmImageClient;

    @Autowired
    private DmitemClient dmitemClient;

    @Override
    public CommonResponse<List<DmimagesDto>> findlunbo() {
        List<DmImage> findlunbo = dmImageClient.findlunbo();
        List<DmimagesDto> list=new ArrayList<>();
        //循环查询对应的实体信息
        for (DmImage item:findlunbo){
            DmimagesDto dmimagesDto=new DmimagesDto();
            dmimagesDto.setImgUrl(item.getImgUrl());
            dmimagesDto.setId(item.getId());
//            System.out.println("编号");
//            System.out.println(item.getTargetId());
            DmItem findbh = dmitemClient.findbh(item.getTargetId());
//            System.out.println("实体'");
//            System.out.println(findbh);
            dmimagesDto.setItemName(findbh.getItemName());
            dmimagesDto.setMinPrice(findbh.getMinPrice());
            list.add(dmimagesDto);
        }
        return DtoUtil.returnSuccess(list);
    }
}
