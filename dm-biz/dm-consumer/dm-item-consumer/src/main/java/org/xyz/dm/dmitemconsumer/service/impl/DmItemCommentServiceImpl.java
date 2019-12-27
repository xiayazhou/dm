package org.xyz.dm.dmitemconsumer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xyz.dm.dmitemconsumer.service.DmItemCommentService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DtoUtil;
import org.xyz.dm.dto.JupingDto;
import org.xyz.dm.entity.DmItemComment;
import org.xyz.dm.item.client.DmItemCommentClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:36
 */
@Service
public class DmItemCommentServiceImpl implements DmItemCommentService {

    @Autowired
    private DmItemCommentClient dmItemCommentClient;

    @Override
    public CommonResponse<List<JupingDto>> findbyitem(Integer bh) {
        List<DmItemComment> finbyitemid = dmItemCommentClient.finbyitemid(bh);
        List<JupingDto> list=new ArrayList<>();
        for (DmItemComment item:finbyitemid) {
            JupingDto jupingDto=new JupingDto();
            BeanUtils.copyProperties(item,jupingDto);
            list.add(jupingDto);
        }
        return DtoUtil.returnSuccess(list);
    }
}
