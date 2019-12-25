package org.xyz.dm.dmitemprovider.restservice;


import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xyz.dm.entity.DmCinema;
import org.xyz.dm.repository.DmCinemaRepositry;

@RestController
public class DmCinemaService {

    @Autowired
    private DmCinemaRepositry dmCinemaRepositry;

    //根据id查询城市
    @GetMapping(path = "/chengshi")
    public DmCinema findbh(@RequestParam("bh") Integer id){
       return dmCinemaRepositry.findbh(id);
    }

}
