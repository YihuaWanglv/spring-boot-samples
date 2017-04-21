package com.iyihua.itimes.dao;

import com.iyihua.itimes.domain.entity.Order;

/**
 * Created by changming.xie on 4/1/16.
 */
public interface OrderDao {

    public void insert(Order order);

    public void update(Order order);
}
