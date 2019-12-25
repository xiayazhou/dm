package org.xyz.dm.dmuserprovider.restservice;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmUser;
import org.xyz.dm.repository.DmUserRepository;

@RestController
public class DmUserService {

    @Autowired
    private DmUserRepository dmUserRepository;

    //登陆
    @PostMapping(path = "/findByPhone")
    public DmUser findByPhone(@RequestParam("phone") String phone){
        return dmUserRepository.findByPhone(phone);
    }

}
