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

    //查询每个主题的热门节目
    @Override
    public CommonResponse<List<ButongTuijianDto>> findid(Integer id) {
        List<DmItem> qianwuming = dmitemClient.qianwuming(id);
        List<ButongTuijianDto> list=new ArrayList<>();
        //查询城市及
        for(DmItem item:qianwuming){
            ButongTuijianDto butongTuijianDto=new ButongTuijianDto();
            BeanUtils.copyProperties(item,butongTuijianDto);
            //查询城市
            DmCinema findnbh = dmCinemaClient.findnbh(item.getCinemaId());
            butongTuijianDto.setAreaId(String.valueOf(findnbh.getId()));
            butongTuijianDto.setAreaName(findnbh.getAreaName());
            list.add(butongTuijianDto);
        }
        return DtoUtil.returnSuccess(list);
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
            loucengDto.setFloor(item.getId());
//            loucengDto.setItemTypeId();
            loucengDto.setItemTypeName(item.getItemName());
            loucengDto.setItemTypeId(item.getItemType1Id());
            List<DmItem> qianwuming = dmitemClient.qianwuming(item.getItemType1Id());
            //循环每个热门节目
            for(DmItem item1:qianwuming){
                DmLoucengremenDto loucengremenDto=new DmLoucengremenDto();
                BeanUtils.copyProperties(item1,loucengremenDto);
                loucengremenDto.setMinPrice(String.valueOf(item1.getMinPrice()));
                loucengremenDto.setEndDate(String.valueOf(item1.getEndTime()));
                loucengremenDto.setStartDate(String.valueOf(item1.getStartTime()));
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
                loucengDto.getItems().add(loucengremenDto);
            }
            list.add(loucengDto);
        }
        return DtoUtil.returnSuccess(list);
    }
    //根据id查询商品
    @Override
    public CommonResponse<JiemuXq> shangpinxq(Integer bh) {
        DmItem shangpinxq = dmitemClient.shangpinxq(bh);
        JiemuXq jiemuXq=new JiemuXq();
        BeanUtils.copyProperties(shangpinxq,jiemuXq);
        DmCinema findnbh = dmCinemaClient.findnbh(shangpinxq.getCinemaId());
//        jiemuXq.setItemName(shangpinxq);
        jiemuXq.setAdress(findnbh.getAddress());
        jiemuXq.setAreaId(findnbh.getAreaId());
        jiemuXq.setAreaName(findnbh.getAreaName());
        jiemuXq.setCinemaId(shangpinxq.getCinemaId());
        jiemuXq.setLatitude(shangpinxq.getLatitude());
        jiemuXq.setLongitude(shangpinxq.getLongitude());
        return DtoUtil.returnSuccess(jiemuXq);
    }
}
