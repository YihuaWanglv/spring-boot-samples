package com.iyihua.itimes.dao;

import com.iyihua.itimes.domain.entity.RedPacketAccount;

/**
 * Created by changming.xie on 4/2/16.
 */
public interface RedPacketAccountDao {

    RedPacketAccount findByUserId(long userId);

    void update(RedPacketAccount redPacketAccount);
}
