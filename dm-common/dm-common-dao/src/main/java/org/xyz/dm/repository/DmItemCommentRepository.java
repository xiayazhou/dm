package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xyz.dm.entity.DmItemComment;

import java.util.List;

/**
 * @description:
 * @author: 夏亚洲
 * @time: 2019/12/27 10:09
 */
public interface DmItemCommentRepository extends JpaRepository<DmItemComment,Integer> {
    //根据商品id查询剧评
    @Query(value = "from DmItemComment where itemId=:bh")
    List<DmItemComment> findByItemId(@Param("bh") Integer bh);
}
