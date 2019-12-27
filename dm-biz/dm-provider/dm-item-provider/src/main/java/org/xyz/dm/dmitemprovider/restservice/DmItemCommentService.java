package org.xyz.dm.dmitemprovider.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmItemComment;
import org.xyz.dm.repository.DmItemCommentRepository;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:17
 */
@RestController
public class DmItemCommentService {

    @Autowired
    private DmItemCommentRepository dmItemCommentRepository;
    //根据id查询剧评
    @PostMapping(path = "/findbyitemid")
    public List<DmItemComment> findbyitemid(@RequestParam("bh") Integer bh){
        return dmItemCommentRepository.findByItemId(bh);
    }

}
