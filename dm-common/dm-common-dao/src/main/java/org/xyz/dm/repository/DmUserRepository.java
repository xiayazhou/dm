package org.xyz.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.xyz.dm.entity.DmUser;

public interface DmUserRepository extends JpaRepository<DmUser,Integer> {
    //登陆
//    @Query
    DmUser findByPhone(@Param("phone") String phone);
}
