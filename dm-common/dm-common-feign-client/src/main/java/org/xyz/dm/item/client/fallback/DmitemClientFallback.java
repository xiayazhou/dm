package org.xyz.dm.item.client.fallback;


import org.springframework.stereotype.Component;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.item.client.DmitemClient;

import java.util.List;

@Component
public class DmitemClientFallback implements DmitemClient {
    public List<DmItem> findid(Integer id) {
        System.out.println("查询出错");
        return null;
    }

    public List<DmItem> findtuijian() {
        System.out.println("今日推荐查询出现异常");
        return null;
    }

    public List<DmItem> findjjkaishou() {
        System.out.println("查询即将开售出现异常");
        return null;
    }
    //根据id查询实体
    public DmItem findbh(Integer id) {
        System.out.println("实体查询出现错误");
        return null;
    }

    public List<DmItem> findfenlei(Integer id) {

        return null;
    }

    public List<DmItem> yijifenlei() {
        System.out.println("分组查询失败");
        return null;
    }

    public List<DmItem> qianwuming(Integer id) {
        System.out.println("前五名查询失败");
        return null;
    }

    @Override
    public DmItem shangpinxq(Integer bh) {
        return null;
    }

}
