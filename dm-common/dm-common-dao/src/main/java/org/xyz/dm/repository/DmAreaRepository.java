package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.xyz.dm.entity.DmArea;

import java.util.List;

public interface DmAreaRepository extends JpaRepository<DmArea,Integer> {

//    //查询热门城市
//    @Query("")
//    List<DmArea> getremen();
}
