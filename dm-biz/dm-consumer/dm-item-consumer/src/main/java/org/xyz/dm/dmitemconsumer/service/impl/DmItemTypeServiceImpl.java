package org.xyz.dm.dmitemconsumer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmitemconsumer.service.DmItemTypeService;
import org.xyz.dm.dto.*;
import org.xyz.dm.entity.DmImage;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.entity.DmItemType;
import org.xyz.dm.item.client.DmImageClient;
import org.xyz.dm.item.client.DmItemTypeClient;
import org.xyz.dm.item.client.DmitemClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmItemTypeServiceImpl implements DmItemTypeService {

    @Autowired
    private DmItemTypeClient dmItemTypeClient;

    @Autowired
    private DmitemClient dmitemClient;

    @Autowired
    private DmImageClient dmImageClient;


    @Override
    public CommonResponse<List<DmItemTypeDto>> queryAllType() {
//        System.out.println("dmitem");
//        System.out.println(dmItemTypeClient);
        List<DmItemType> dmItemTypesParent = dmItemTypeClient.findByParent(0);
        List<DmItemTypeDto>  dmItemTypeDtos = new ArrayList<>();

        for(DmItemType dmItemType : dmItemTypesParent){
            DmItemTypeDto dmItemTypeDto = new DmItemTypeDto();
            BeanUtils.copyProperties(dmItemType, dmItemTypeDto);
            List<DmItemType> dmItemTypesChildren = dmItemTypeClient.findByParent(dmItemTypeDto.getId().intValue());
            for(DmItemType dmItemType1 : dmItemTypesChildren){
                DmItemTypeDto dmItemTypeDto1 = new DmItemTypeDto();
                BeanUtils.copyProperties(dmItemType1, dmItemTypeDto1);
//                dmItemTypeDto.getChildren().add(dmItemTypeDto1);
            }
//            dmItemTypeDto.setChildren(dmItemTypeDtos);
            dmItemTypeDtos.add(dmItemTypeDto);
        }
        return DtoUtil.returnSuccess(dmItemTypeDtos);
    }
    //查询

    @Override
    public CommonResponse<List<DmItemTypeDto>> finddaoh() {
        List<DmItemType> dmItemTypesParent = dmItemTypeClient.findByParent(0);
        List<DmItemTypeDto>  dmItemTypeDtos = new ArrayList<>();
        for(DmItemType dmItemType : dmItemTypesParent){
            DmItemTypeDto dmItemTypeDto = new DmItemTypeDto();
            BeanUtils.copyProperties(dmItemType, dmItemTypeDto);
            List<DmItemType> dmItemTypesChildren = dmItemTypeClient.findByParent(dmItemTypeDto.getId().intValue());
//            //循环查询二级目录
            for(DmItemType dmItemType1 : dmItemTypesChildren){
                childrenDto dmItemTypeDto1 = new childrenDto();
                BeanUtils.copyProperties(dmItemType1, dmItemTypeDto1);
                dmItemTypeDto1.setId(Integer.valueOf(String.valueOf(dmItemType1.getId())));
                dmItemTypeDto1.setAliasName("value");
                dmItemTypeDto1.setLevel(Integer.valueOf(dmItemType1.getLevel()));
//                System.out.println(dmItemTypeDto1);
                dmItemTypeDto.getChildren().add(dmItemTypeDto1);
            }
//            //循环查询热门节目
            System.out.println(dmItemType.getId());
            List<DmItem> itemlist = dmitemClient.findid(dmItemType.getId().intValue());
            for (DmItem item:itemlist){
                DmItemDto itemDao=new DmItemDto();
                //循环转换
                BeanUtils.copyProperties(item,itemDao);
                dmItemTypeDto.getHotItems().add(itemDao);
                //
            }
//            dmItemTypeDto.setChildren(dmItemTypeDtos);
//            System.out.println(dmItemTypeDtos);
            dmItemTypeDtos.add(dmItemTypeDto);
        }
        return DtoUtil.returnSuccess(dmItemTypeDtos);
    }

    @Override
    public CommonResponse<List<DmItemTypeDto>> findyiji() {
        //查询导航信息
        List<DmItemType> list = dmItemTypeClient.findByParent(0);
        List<DmItemTypeDto> list1=new ArrayList<>();
        for (DmItemType dto:list){
            DmItemTypeDto dmItemTypeDto = new DmItemTypeDto();
            BeanUtils.copyProperties(dto, dmItemTypeDto);
//            dmItemTypeDto.get
            list1.add(dmItemTypeDto);
        }
        return DtoUtil.returnSuccess(list1);
    }

    @Override
    public CommonResponse<List<DmDaohangDto>> yiji() {
        //查询导航信息
        List<DmItemType> list = dmItemTypeClient.findByParent(0);
        List<DmDaohangDto> list1=new ArrayList<>();
        for (DmItemType dto:list){
            DmDaohangDto dmItemTypeDto = new DmDaohangDto();
            BeanUtils.copyProperties(dto, dmItemTypeDto);
            dmItemTypeDto.setLevel(Integer.valueOf(dto.getLevel()));
            dmItemTypeDto.setId(Integer.valueOf(String.valueOf(dto.getId())));
//            dmItemTypeDto.get
            list1.add(dmItemTypeDto);
        }
        return DtoUtil.returnSuccess(list1);
    }
}
