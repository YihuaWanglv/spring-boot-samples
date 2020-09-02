package com.qkc.bus.phoenix.hbase.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SeeKnowledgePersonal {
    @Id
    String id;
    @NotNull
    @Column(name = "student_id")
    String studentId;
    @NotNull
    @Column(name = "knowledge_subject_code")
    String knowledgeSubjectCode;
    @NotNull
    @Column(name = "knowledge_module_code")
    String knowledgeModuleCode;
    @NotNull
    @Column(name = "knowledge_unit_code")
    String knowledgeUnitCode;
    @NotNull
    @Column(name = "knowledge_point_code")
    String knowledgePointCode;
    @Column(name = "last_time")
    Date lastTime;
    @Column(name = "last_result")
    String lastResult;
    @Column(name = "right_num")
    Integer rightNum;
    @Column(name = "memory_value")
    Integer memoryValue;
    @Column(name = "experience_value")
    Integer experienceValue;
    @Column(name = "creater_user")
    String createrUser;
    @Column(name = "creater_time")
    Date createrTime;
    @Column(name = "modified_user")
    String modifiedUser;
    @Column(name = "modified_time")
    Date modifiedTime;

    @Transient
    Integer limit; // 分页查询的分页入参参数,用于数据库查询的分页字段
    // 分页查询的分页入参参数
    @Transient
    Integer page;
    // 用于数据库查询的分页字段
    @Transient
    Integer offset;

    // 数据库查询排序字段
    @Transient
    String sortBy;
    @Transient
    String sortType;


    public void settingOffset() {
        if (page == null || page <= 0) {
            throw new IllegalArgumentException("分页查询需要提供page参数");
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        offset = (page - 1) * limit;
    }
}
