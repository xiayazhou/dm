package org.xyz.dm.dmbaseconsoumer.service;

import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmimagesDto;
import org.xyz.dm.entity.DmImage;

import java.util.List;

public interface DmimageService {

    //查询首页轮播图
    CommonResponse<List<DmimagesDto>> findlunbo();
}
