package com.iyihua.itimes.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iyihua.itimes.dao.RedPacketAccountDao;
import com.iyihua.itimes.domain.entity.RedPacketAccount;

/**
 * Created by changming.xie on 4/2/16.
 */
@Repository
public class RedPacketAccountRepository {

    @Autowired
    RedPacketAccountDao redPacketAccountDao;

    public RedPacketAccount findByUserId(long userId) {

        return redPacketAccountDao.findByUserId(userId);
    }

    public void save(RedPacketAccount redPacketAccount) {
        redPacketAccountDao.update(redPacketAccount);
    }
}
