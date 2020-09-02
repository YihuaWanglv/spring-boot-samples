package com.qkc.bus.phoenix.hbase.mapper;

import com.qkc.bus.phoenix.hbase.domains.SeeKnowledgePersonal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SeeKnowledgePersonalMapper {

    List<SeeKnowledgePersonal> testQuery();

    int save(SeeKnowledgePersonal seeKnowledgePersonal);

    int deleteById(@Param("id") String id);

    @Select("select * from see_knowledge_personal where id=#{id}")
    SeeKnowledgePersonal getById(String id);

    List<SeeKnowledgePersonal> fetchByParams(SeeKnowledgePersonal params);

    Long countByParams(SeeKnowledgePersonal params);
}
