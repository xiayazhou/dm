package org.xyz.dm.dmitemprovider.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmUser;
import org.xyz.dm.repository.DmUserRepository;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DmUserService {

    @Resource
    private DmUserRepository repository;

    @PostMapping(path = "/getAll")
    public List<DmUser> getAll() {
        return repository.findAll();
    }


}
