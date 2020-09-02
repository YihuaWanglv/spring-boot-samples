package com.qkc.bus.phoenix.api;

import com.qkc.bus.phoenix.mapper.AppBannerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    AppBannerMapper appBannerMapper;

    @GetMapping(value = "/test")
    public ResponseEntity test() {
        return ResponseEntity.ok().body(appBannerMapper.selectAll());
    }
}
