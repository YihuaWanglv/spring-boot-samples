package com.iyihua.itimes.web.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyihua.itimes.service.PlaceOrderServiceImpl;
import com.iyihua.itimes.web.controller.vo.PlaceOrderRequest;

/**
 * Created by changming.xie on 4/1/16.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    PlaceOrderServiceImpl placeOrderService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String placeOrder(String value) {

        PlaceOrderRequest request = buildRequest(value);

        placeOrderService.placeOrder(request.getPayerUserId(), request.getShopId(),
                request.getProductQuantities(), request.getRedPacketPayAmount());
        return "success";
    }

    private PlaceOrderRequest buildRequest(String v) {
        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setPayerUserId(1000);
        request.setShopId(1);
        request.setRedPacketPayAmount(BigDecimal.TEN);
        request.getProductQuantities().add(new ImmutablePair<Long, Integer>(1L, 1));
        return request;
    }
}
