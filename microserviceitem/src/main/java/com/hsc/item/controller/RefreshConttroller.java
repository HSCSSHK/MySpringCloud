package com.hsc.item.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RefreshConttroller {

    @PostMapping("/refresh")
    public String refresh() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置content_type为json要不然会报415的错误
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, httpHeaders);
        //# 以post方法访问真正的刷新链接
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8080/actuator/refresh",
                request, String.class);
        System.out.println("refresh = "+stringResponseEntity.getBody());
        return "success";
    }

}
