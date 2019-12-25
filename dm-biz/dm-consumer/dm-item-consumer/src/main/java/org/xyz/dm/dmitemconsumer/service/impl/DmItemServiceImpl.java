package org.xyz.dm.dmitemconsumer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmitemconsumer.service.DmItemService;
import org.xyz.dm.dto.*;
import org.xyz.dm.entity.DmCinema;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.DmCinemaClient;
import org.xyz.dm.item.client.DmImageClient;
import org.xyz.dm.item.client.DmitemClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmItemServiceImpl implements DmItemService {

    @Autowired
    private DmitemClient dmitemClient;

    @Autowired
    private DmImageClient dmImageClient;

    @Autowired
    private DmCinemaClient dmCinemaClient;


    @Override
    public List<DmItem> findid(Integer id) {
        return dmitemClient.findid(id);
    }

//查询推荐
    @Override
    public CommonResponse<List<DmItemDto>> findtuijian() {
        List<DmItem> findtuijian = dmitemClient.findtuijian();
        List<DmItemDto> list=new ArrayList<>();
        for (DmItem item:findtuijian){
            DmItemDto d=new DmItemDto();
            BeanUtils.copyProperties(item,d);
            //查询图片信息
            DmImage findjmid = dmImageClient.findjmid(item.getId());
            d.setImgUrl(findjmid.getImgUrl());
            list.add(d);
        }
        return DtoUtil.returnSuccess(list);
    }
//即将开售
    @Override
    public CommonResponse<List<DmItemDto>> findjjkaishou() {
        List<DmItem> findjjkaishou = dmitemClient.findjjkaishou();
        List<DmItemDto> list=new ArrayList<>();
        for (DmItem item:findjjkaishou){
            DmItemDto d=new DmItemDto();
            BeanUtils.copyProperties(item,d);
            //查询图片信息
            DmImage findjmid = dmImageClient.findjmid(item.getId());
            if (findjmid!=null){
                d.setImgUrl(findjmid.getImgUrl());
            }
//            list.add(d);
            list.add(d);
        }
        return DtoUtil.returnSuccess(list);
    }
    //不同分类查询
    @Override
    public CommonResponse<List<DmFenleiDto>> findfenlei() {
        List<DmItem> findfenlei = dmitemClient.findfenlei(1);
        List<DmFenleiDto> fenleiDtos=new ArrayList<>();
        for (DmItem item:findfenlei){
            DmFenleiDto fenleiDto=new DmFenleiDto();
            //查询城市
            DmCinema findnbh = dmCinemaClient.findnbh(item.getCinemaId());
            fenleiDto.setId(item.getId());
            fenleiDto.setItemName(item.getItemName());
            fenleiDto.setAreaId(findnbh.getId());
            fenleiDto.setAreaName(findnbh.getName());
            fenleiDtos.add(fenleiDto);
        }
        return DtoUtil.returnSuccess(fenleiDtos);
    }

    @Override
    public CommonResponse<List<DmLoucengDto>> loucengfenlei() {
        //首先查询所有的一级分类
        List<DmItem> yijifenlei = dmitemClient.yijifenlei();
        List<DmLoucengDto> list=new ArrayList<>();
        //通过一级分类查询到所有的热门节目的前五名
        for (DmItem item:yijifenlei){
            DmLoucengDto loucengDto=new DmLoucengDto();
            List<DmItem> qianwuming = dmitemClient.qianwuming(item.getItemType1Id());
            //循环每个热门节目
            for(DmItem item1:qianwuming){
                DmLoucengremenDto loucengremenDto=new DmLoucengremenDto();
                BeanUtils.copyProperties(item1,loucengremenDto);
                //查询查询城市
                //查询城市
                DmCinema findnbh = dmCinemaClient.findnbh(item1.getCinemaId());
                loucengremenDto.setAreaId(findnbh.getId());
                loucengremenDto.setAreaName(findnbh.getName());
                loucengremenDto.setAddress(findnbh.getAddress());
                //查询图片
                //查询图片信息
                DmImage findjmid = dmImageClient.haibao(item1.getId());
                if (findjmid!=null){
                    loucengremenDto.setImgUrl(findjmid.getImgUrl());
                }
                loucengDto.getLouceng().add(loucengremenDto);
            }
            list.add(loucengDto);
        }
        return DtoUtil.returnSuccess(list);
    }
}
