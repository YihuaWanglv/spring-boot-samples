package com.iyihua.itimes.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.itimes.domain.entity.Order;
import com.iyihua.itimes.domain.entity.Shop;
import com.iyihua.itimes.domain.repository.ShopRepository;
import com.iyihua.itimes.domain.service.OrderServiceImpl;
import com.iyihua.itimes.domain.service.PaymentServiceImpl;

/**
 * Created by changming.xie on 4/1/16.
 */
@Service
public class PlaceOrderServiceImpl {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    PaymentServiceImpl paymentService;

    public void placeOrder(long payerUserId, long shopId, List<Pair<Long, Integer>> productQuantities,BigDecimal redPacketPayAmount) {
        Shop shop = shopRepository.findById(shopId);
        Order order = orderService.createOrder(payerUserId,shop.getOwnerUserId(),productQuantities);
        paymentService.makePayment(order,redPacketPayAmount,order.getTotalAmount().subtract(redPacketPayAmount));
    }
}
