package org.xyz.dm.dmitemprovider.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmUser;
import org.xyz.dm.repository.DmUserRepository;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DmUserService {

    @Autowired
    private DmUserRepository repository;

    @PostMapping(path = "/getAll")
    public List<DmUser> getAll() {
        return repository.findAll();
    }


}
