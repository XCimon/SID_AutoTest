package com.example.demo.persistance;

import com.example.demo.persistance.dao.PlatMapper;
import com.example.demo.persistance.model.Plat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Cirmons
 * @Date: 2021-10-09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class datatest {
    
    
    @Autowired
    private PlatMapper platMapper;
    
    @Test
    public void testSelect(){
        Plat a = platMapper.getAllRecord("1417803126848622593");
        System.out.println(1);
    }
    
}
