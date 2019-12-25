package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xyz.dm.entity.DmCinema;


public interface DmCinemaRepositry extends JpaRepository<DmCinema,Integer> {

    //根据id查询城市
    @Query("from DmCinema where id=:bh")
    DmCinema findbh(@Param("bh") Integer id);

}
