package com.iyihua.itimes.services;

import org.mengyun.tcctransaction.Compensable;
import org.mengyun.tcctransaction.api.TransactionContext;
import org.mengyun.tcctransaction.sample.dubbo.redpacket.api.RedPacketTradeOrderService;
import org.mengyun.tcctransaction.sample.dubbo.redpacket.api.dto.RedPacketTradeOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.itimes.domain.entity.RedPacketAccount;
import com.iyihua.itimes.domain.repository.RedPacketAccountRepository;

/**
 * Created by changming.xie on 4/2/16.
 */
@Service("redPacketTradeOrderService")
public class RedPacketTradeOrderServiceImpl implements RedPacketTradeOrderService {

    @Autowired
    RedPacketAccountRepository redPacketAccountRepository;

    @Override
    @Compensable(confirmMethod = "confirmRecord",cancelMethod = "cancelRecord")
    public void record(TransactionContext transactionContext, RedPacketTradeOrderDto tradeOrderDto) {
        System.out.println("red packet try record called");

        RedPacketAccount transferFromAccount = redPacketAccountRepository.findByUserId(tradeOrderDto.getSelfUserId());

        transferFromAccount.transferFrom(tradeOrderDto.getAmount());
//        if (1==1) {
//        	throw new IllegalArgumentException("For test tcc transaction.....................................");			
//		}

        redPacketAccountRepository.save(transferFromAccount);
    }

    public void confirmRecord(TransactionContext transactionContext, RedPacketTradeOrderDto tradeOrderDto) {
        System.out.println("red packet confirm record called");

        RedPacketAccount transferToAccount = redPacketAccountRepository.findByUserId(tradeOrderDto.getOppositeUserId());

        transferToAccount.transferTo(tradeOrderDto.getAmount());

        redPacketAccountRepository.save(transferToAccount);
    }

    public void cancelRecord(TransactionContext transactionContext, RedPacketTradeOrderDto tradeOrderDto) {
        System.out.println("red packet cancel record called");

        RedPacketAccount capitalAccount = redPacketAccountRepository.findByUserId(tradeOrderDto.getSelfUserId());

        capitalAccount.cancelTransfer(tradeOrderDto.getAmount());

        redPacketAccountRepository.save(capitalAccount);
    }
}
