package com.iyihua.itimes.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iyihua.itimes.dao.OrderDao;
import com.iyihua.itimes.dao.OrderLineDao;
import com.iyihua.itimes.domain.entity.Order;
import com.iyihua.itimes.domain.entity.OrderLine;

/**
 * Created by changming.xie on 4/1/16.
 */
@Repository
public class OrderRepository {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderLineDao orderLineDao;

    public void createOrder(Order order) {
        orderDao.insert(order);

        for(OrderLine orderLine:order.getOrderLines()) {
            orderLineDao.insert(orderLine);
        }
    }

    public void updateOrder(Order order) {
        orderDao.update(order);
    }
}
