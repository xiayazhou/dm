package org.xyz.dm.dmduanxin.service;

import org.xyz.dm.entity.DmUser;

public interface DxService {

    //发送验证码
    Boolean fasong(String model);

    //验证码验证
    Boolean  yanzheng(DmUser dmUser,String code);
}
