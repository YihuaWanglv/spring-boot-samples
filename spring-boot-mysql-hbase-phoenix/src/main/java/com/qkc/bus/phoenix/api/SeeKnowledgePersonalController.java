package com.qkc.bus.phoenix.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qkc.bus.phoenix.hbase.domains.SeeKnowledgePersonal;
import com.qkc.bus.phoenix.hbase.mapper.SeeKnowledgePersonalMapper;
import com.qkc.bus.phoenix.service.SeeKnowledgePersonalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RequestMapping(value = "see-knowledge-personal")
@RestController
public class SeeKnowledgePersonalController {

    @Resource
    SeeKnowledgePersonalService seeKnowledgePersonalService;
    @Resource
    SeeKnowledgePersonalMapper seeKnowledgePersonalMapper;

    @GetMapping(value = "")
    public ResponseEntity list(SeeKnowledgePersonal seeKnowledgePersonal) {
        log.info(seeKnowledgePersonal.toString());
        if (seeKnowledgePersonal.getPage() != null && seeKnowledgePersonal.getPage() > 0) {
            if (seeKnowledgePersonal.getLimit() == null || seeKnowledgePersonal.getLimit() <= 0) {
                seeKnowledgePersonal.setLimit(10);
            }
            Page<SeeKnowledgePersonal> list = seeKnowledgePersonalService.fetchByParamsWithPage(seeKnowledgePersonal);
            return ResponseEntity.ok().body(list);
        } else {
            List<SeeKnowledgePersonal> list = seeKnowledgePersonalService.fetchByParams(seeKnowledgePersonal);
            return ResponseEntity.ok().body(list);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity create(SeeKnowledgePersonal seeKnowledgePersonal) {
        seeKnowledgePersonalService.save(seeKnowledgePersonal);
        return ResponseEntity.ok().body(seeKnowledgePersonal);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable String id, SeeKnowledgePersonal seeKnowledgePersonal) {
        seeKnowledgePersonal.setId(id);
        seeKnowledgePersonalService.save(seeKnowledgePersonal);
        return ResponseEntity.ok().body(seeKnowledgePersonal);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        SeeKnowledgePersonal seeKnowledgePersonal = seeKnowledgePersonalService.getById(id);
        return ResponseEntity.ok().body(seeKnowledgePersonal);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        seeKnowledgePersonalService.deleteById(id);
        return ResponseEntity.ok().body(true);
    }
}