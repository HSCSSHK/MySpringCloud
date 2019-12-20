package com.hsc.item.controller;

import com.hsc.item.config.JdbcConfigBean;
import com.hsc.item.entity.Item;
import com.hsc.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Value("${server.port}")
    private String port;
    @Value("${env}")
    private String env;
    @Autowired
    private ItemService itemService;

    @Autowired
    private JdbcConfigBean jdbcConfigBean;

    /**
     * 对外提供接口服务，查询商品信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "item/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        System.out.println("service port："+port);
        return this.itemService.queryItemById(id);
    }

    @GetMapping(value = "item2/{id}")
    public Item queryItemById2(@PathVariable("id") Long id,@RequestParam String token) {
        System.out.println("service port："+port);
        return this.itemService.queryItemById(id);
    }
    @GetMapping(value = "testconfig1")
    public String testconfig1(){
        return this.jdbcConfigBean.toString();
    }

   @GetMapping(value = "testconfig")
    public String testconfig(){
       System.out.println("service env："+env);
       return "success";
   }

    @PostMapping("/qChoice")
    public String testconfig3(){
        System.out.println("service env："+env);
        return "success";
    }
}
