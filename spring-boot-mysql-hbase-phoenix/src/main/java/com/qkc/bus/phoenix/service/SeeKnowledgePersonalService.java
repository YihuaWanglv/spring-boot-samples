package com.qkc.bus.phoenix.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qkc.bus.phoenix.core.BeanValidationHelper;
import com.qkc.bus.phoenix.hbase.domains.SeeKnowledgePersonal;
import com.qkc.bus.phoenix.hbase.mapper.SeeKnowledgePersonalMapper;
import com.qkc.bus.phoenix.util.SequenceGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SeeKnowledgePersonalService {

    @Resource
    SeeKnowledgePersonalMapper seeKnowledgePersonalMapper;

    public void save(SeeKnowledgePersonal seeKnowledgePersonal) {

        if (StringUtils.isEmpty(seeKnowledgePersonal.getId())) {

            seeKnowledgePersonal.setId(SequenceGenerator.nextStringId());
            if (StringUtils.isEmpty(seeKnowledgePersonal.getLastResult())) {
                seeKnowledgePersonal.setLastResult("");
            }
            if (seeKnowledgePersonal.getLastTime() == null) {
                seeKnowledgePersonal.setLastTime(new Date());
            }
            seeKnowledgePersonal.setCreaterTime(new Date());
            seeKnowledgePersonal.setModifiedTime(new Date());
            if (StringUtils.isEmpty(seeKnowledgePersonal.getCreaterUser())) {
                seeKnowledgePersonal.setCreaterUser("");
            }
            if (StringUtils.isEmpty(seeKnowledgePersonal.getModifiedUser())) {
                seeKnowledgePersonal.setModifiedUser("");
            }
            if (seeKnowledgePersonal.getRightNum() == null) {
                seeKnowledgePersonal.setRightNum(0);
            }
            if (seeKnowledgePersonal.getExperienceValue() == null) {
                seeKnowledgePersonal.setExperienceValue(0);
            }
            if (seeKnowledgePersonal.getMemoryValue() == null) {
                seeKnowledgePersonal.setMemoryValue(0);
            }
            BeanValidationHelper.getInstance().valid(seeKnowledgePersonal);
            seeKnowledgePersonalMapper.save(seeKnowledgePersonal);
        } else {
            SeeKnowledgePersonal exist = seeKnowledgePersonalMapper.getById(seeKnowledgePersonal.getId());
            Assert.notNull(exist, "原记录不存在");
            BeanUtil.copyProperties(seeKnowledgePersonal, exist, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            BeanValidationHelper.getInstance().valid(exist);
            seeKnowledgePersonalMapper.save(exist);
        }

    }

    public SeeKnowledgePersonal getById(String id) {
        return seeKnowledgePersonalMapper.getById(id);
    }

    public int deleteById(String id) {
        return seeKnowledgePersonalMapper.deleteById(id);
    }

    public List<SeeKnowledgePersonal> fetchByParams(SeeKnowledgePersonal params) {
        return seeKnowledgePersonalMapper.fetchByParams(params);
    }

    public Page<SeeKnowledgePersonal> fetchByParamsWithPage(SeeKnowledgePersonal params) {
        Assert.notNull(params.getPage(), "分页查询请提供page参数");
        if (params.getLimit() == null || params.getLimit() <= 0) {
            params.setLimit(10);
        }
        params.settingOffset();
        Page<SeeKnowledgePersonal> pageList = new Page<>(params.getPage(), params.getLimit());
        log.info("params={}", params.toString());
        Long total = seeKnowledgePersonalMapper.countByParams(params);
        List<SeeKnowledgePersonal> list = seeKnowledgePersonalMapper.fetchByParams(params);
        pageList.setTotal(total);
        pageList.setRecords(list);
        return pageList;
    }
}
