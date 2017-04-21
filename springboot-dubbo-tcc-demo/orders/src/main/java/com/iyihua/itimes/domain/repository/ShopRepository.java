package com.iyihua.itimes.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iyihua.itimes.dao.ShopDao;
import com.iyihua.itimes.domain.entity.Shop;

/**
 * Created by changming.xie on 4/1/16.
 */
@Repository
public class ShopRepository {

    @Autowired
    ShopDao shopDao;

    public Shop findById(long id) {

        return shopDao.findById(id);
    }
}
