package com.iyihua.itimes.domain.factory;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.iyihua.itimes.domain.entity.Order;
import com.iyihua.itimes.domain.entity.OrderLine;

/**
 * Created by changming.xie on 4/1/16.
 */
public class OrderFactory {


    public static Order buildOrder(long payerUserId, long payeeUserId, List<Pair<Long, Integer>> productQuantities) {

        Order order = new Order(payerUserId, payeeUserId);

        for (Pair<Long, Integer> pair : productQuantities) {
            order.addOrderLine(new OrderLine(pair.getLeft(), pair.getRight(), BigDecimal.valueOf(60)));
        }

        return order;
    }
}
