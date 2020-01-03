package org.xyz.dm.dmitemconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.dmitemconsumer.service.DmItemCommentService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.JupingDto;
import org.xyz.dm.entity.DmItemComment;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 16:53
 */
@RestController
public class DmItemCommentController {

    @Autowired
    private DmItemCommentService dmItemCommentService;

    //根据id查询剧评
    @PostMapping(path = "/fidnbyid")
    public CommonResponse<List<JupingDto>> findbyitemid(@RequestParam("bh") Integer bh){
        return dmItemCommentService.findbyitem(bh);
    }

}
