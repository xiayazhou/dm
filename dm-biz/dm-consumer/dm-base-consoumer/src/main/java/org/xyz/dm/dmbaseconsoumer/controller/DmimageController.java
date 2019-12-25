package org.xyz.dm.dmbaseconsoumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmbaseconsoumer.service.DmimageService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmimagesDto;

import java.util.List;

@RestController
public class DmimageController {

    @Autowired
    private DmimageService dmimageService;

    //查询轮播图
    @PostMapping(path = "/findlunbo")
    public CommonResponse<List<DmimagesDto>> findlunbo(){
       return dmimageService.findlunbo();
    }
}
