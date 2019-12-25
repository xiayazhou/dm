package org.xyz.dm.dmuserconsoumer.service.impl;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.xyz.dm.dmuserconsoumer.service.DmUserService;
import org.xyz.dm.dto.CommonResponse;
import org.xyz.dm.dto.DmUserDto;
import org.xyz.dm.dto.DtoUtil;
import org.xyz.dm.entity.DmUser;
import org.xyz.dm.item.client.DmUserClient;

@Service
public class DmUserServiceImpl implements DmUserService {

    @Autowired
    private DmUserClient dmUserClient;

    @Override
    public CommonResponse<DmUserDto> findByPhone(@RequestParam("phone") String phone) {
        DmUser dmUser=dmUserClient.findByPhone(phone);
        DmUserDto dmUserDto=new DmUserDto();
        System.out.println(dmUser);
//        BeanUtils.copyProperties(dmUser,dmUserDto);
        return DtoUtil.returnSuccess(dmUserDto);
    }
}
