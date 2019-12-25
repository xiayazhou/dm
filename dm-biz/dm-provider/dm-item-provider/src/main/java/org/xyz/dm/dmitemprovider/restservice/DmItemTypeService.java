package org.xyz.dm.dmitemprovider.restservice;


//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmItemType;
import org.xyz.dm.repository.DmItemTypeRepository;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DmItemTypeService {

    @Resource
    private DmItemTypeRepository dmItemTypeRepository;

    @PostMapping(path = "/findByParent")
    public List<DmItemType> findByParent(@RequestParam("parent") Integer parent) {
        List<DmItemType> list = dmItemTypeRepository.findByParent(parent);
//        System.out.println("提供者");
        System.out.println(list);
        return list;
    }

//    //查询今日推荐
//    @PostMapping(path = "/findtuijian")
//    public List<DmItemType> findtuijian(){
//        return dmItemTypeRepository();
//    }

}
