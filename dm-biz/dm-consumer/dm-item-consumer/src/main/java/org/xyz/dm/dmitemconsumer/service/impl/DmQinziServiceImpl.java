package org.xyz.dm.dmitemconsumer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmitemconsumer.service.DmQinziService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmLoucengremenDto;
import org.xyz.dm.dto.DtoUtil;
import org.xyz.dm.entity.DmCinema;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.DmCinemaClient;
import org.xyz.dm.item.client.DmImageClient;
import org.xyz.dm.item.client.DmQinziClient;

import java.util.ArrayList;
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

//    @Autowired
//    private DmImageClient dmImageClient;
//
//    @Autowired
//    private DmCinemaClient dmCinemaClient;

    @Autowired
    private DmCinemaClient dmCinemaClient;


    @Override
    public CommonResponse<List<DmLoucengremenDto>> getQinzi(Integer areaId, Integer limit) {
//        System.out.println(areaId);
//        System.out.println(limit);
        //根据城市编号查询信息
        List<DmItem> qInzi = dmQinziClient.getQInzi(areaId, limit);
//        查询出对应的城市
        DmCinema findnbh = dmCinemaClient.findnbh(areaId);
        System.out.println(findnbh);
        //根据商品id查询图片
//        DmCinema findnbh = dmCinemaClient.findnbh(areaId);
        List<DmLoucengremenDto> list=new ArrayList<>();
        for(DmItem in:qInzi){
            DmLoucengremenDto dmLoucengremenDto=new DmLoucengremenDto();
//            System.out.println(in);
            dmLoucengremenDto.setId(in.getId());
            dmLoucengremenDto.setItemName(in.getItemName());
            dmLoucengremenDto.setAreaId(findnbh.getId());
            dmLoucengremenDto.setAreaName(findnbh.getAreaName());
            dmLoucengremenDto.setEndDate(String.valueOf(in.getEndTime()));
            dmLoucengremenDto.setStartDate(String.valueOf(in.getStartTime()));
            dmLoucengremenDto.setAddress(findnbh.getAddress());
            dmLoucengremenDto.setMinPrice(String.valueOf(in.getMinPrice()));
//            BeanUtils.copyProperties(in,dmLoucengremenDto);
//            DmImage findjmid = dmImageClient.findjmid(in.getId());
//            dmLoucengremenDto.setImgUrl(findjmid.getImgUrl());
            list.add(dmLoucengremenDto);
        }
        return DtoUtil.returnSuccess(list);
    }
    //根据年龄段拆线呢
    @Override
    public CommonResponse<List<DmLoucengremenDto>> gerage(Integer age, Integer limit) {
        //根据年龄段查询
        List<DmItem> getage = dmQinziClient.getage(age, limit);
        List<DmLoucengremenDto> list=new ArrayList<>();
        for (DmItem item:getage){
            DmLoucengremenDto dmLoucengremenDto=new DmLoucengremenDto();
            BeanUtils.copyProperties(item,dmLoucengremenDto);
            dmLoucengremenDto.setStartDate(String.valueOf(item.getStartTime()));
            dmLoucengremenDto.setEndDate(String.valueOf(item.getEndTime()));
            dmLoucengremenDto.setMinPrice(String.valueOf(item.getMinPrice()));
            //查询城市
            DmCinema findnbh = dmCinemaClient.findnbh(item.getCinemaId());
            dmLoucengremenDto.setAreaId(findnbh.getId());
            dmLoucengremenDto.setAreaName(findnbh.getAreaName());
            dmLoucengremenDto.setAddress(findnbh.getAddress());
            list.add(dmLoucengremenDto);
        }
        return DtoUtil.returnSuccess(list);
    }
}
