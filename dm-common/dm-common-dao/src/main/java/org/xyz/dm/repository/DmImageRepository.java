package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xyz.dm.entity.DmImage;

import java.util.List;
//import sun.misc.JavaAWTAccess;

public interface DmImageRepository extends JpaRepository<DmImage,Integer>{

    /**
     * 查询轮播图
     */
    //查询首页轮播图

    @Query("from DmImage where type=1")
    List<DmImage> findlunbo();

    //根据节目id查询图片
    @Query(value = "select * from dm_image where targetId=:id limit 1",nativeQuery = true)
    DmImage findjmid(@Param("id") Integer id);

    //查询海报
    @Query(value = "select * from `dm_image` where targetid=:id and type=2",nativeQuery = true)
    DmImage haibao(@Param("id") Integer id);



}
