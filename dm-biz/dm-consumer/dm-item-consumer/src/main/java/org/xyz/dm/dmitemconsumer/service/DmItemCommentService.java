package org.xyz.dm.dmitemconsumer.service;

//import javax.xml.stream.events.Comment;

import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.JupingDto;

import java.util.List;

public interface DmItemCommentService {
    //根据id查询剧评
    CommonResponse<List<JupingDto>> findbyitem(Integer bh);
}
