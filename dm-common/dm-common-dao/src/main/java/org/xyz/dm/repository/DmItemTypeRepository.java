package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xyz.dm.entity.DmItemType;

import java.util.List;

public interface DmItemTypeRepository extends JpaRepository<DmItemType,Long> {
    @Query("from DmItemType where parent = :parent")
    List<DmItemType> findByParent(@Param("parent")Integer parent);



}
