package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xyz.dm.entity.DmItem;
import org.xyz.dm.entity.DmItemType;

import java.util.List;

public interface DmItemRepository extends JpaRepository<DmItem,Integer> {

    @Query("from DmItem where itemType1Id=:itemtypeid and isBanner=1 and isRecommend=1 and state=3")
    List<DmItem> findid(@Param("itemtypeid") Integer itmetypeid);
    //查询今日推荐
    @Query(value = "select * from dm_item where isRecommend=1 limit 6",nativeQuery = true)
    List<DmItem> findtuijian();
    //查询即将开售的
    @Query(value = "select * from dm_item where state=2 limit 6",nativeQuery = true)
    List<DmItem> findjjkaishou();

    //根据id查询实体
    @Query(value = "select * from dm_item where id=:bh",nativeQuery = true)
    DmItem findbh(@Param("bh") Integer bh);

    //查询不同分类的信息
    @Query("from DmItem where itemType1Id=:id")
    List<DmItem> findfeilei(@Param("id") Integer id);

    //分组查询所有的一级编号
    @Query(value = "select * from `dm_item` group by itemType1Id",nativeQuery = true)
    List<DmItem> yijifenlei();

    //查询热门的前五名
    @Query(value = "select * from `dm_item` where itemType1Id=:id order by avgScore desc limit 5",nativeQuery = true)
    List<DmItem> qianwum(@Param("id") Integer id);

}
