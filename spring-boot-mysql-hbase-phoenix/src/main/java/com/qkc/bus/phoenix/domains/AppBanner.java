package com.qkc.bus.phoenix.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_banner")
public class AppBanner {
    @Id
    @Column(name = "banner_id")
    private Long bannerId;

    /**
     * 标题
     */
    @Column(name = "banner_title")
    private String bannerTitle;

    /**
     * 链接地址
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 轮播图URL
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 是否在小程序中隐藏,1=隐藏，0=不隐藏
     */
    @Column(name = "hide_in_minapp")
    private Integer hideInMinapp;

    private Integer sort;

    /**
     * 状态：0=下架，1=上架
     */
    private Integer state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人用户ID
     */
    @Column(name = "create_user")
    private Long createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新人用户ID
     */
    @Column(name = "update_user")
    private Long updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否已删除：0=未删除，1=已删除
     */
    @Column(name = "is_deleted")
    private Integer isDeleted;

}