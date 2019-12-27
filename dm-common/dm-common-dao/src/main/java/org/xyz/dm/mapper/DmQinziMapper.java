package org.xyz.dm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.xyz.dm.dto.DmLoucengremenDto;
import org.xyz.dm.entity.DmItem;

import java.util.List;

@Mapper
public interface DmQinziMapper {

    //亲子页面。根据热门城市查询热门排行
    List<DmItem> getRemen(@Param("areaId") Integer areaId, @Param("limit") Integer limit);
    //根据年龄段查询节目
    List<DmItem> nianlin(@Param("age") Integer age,@Param("limit") Integer limit);

}
