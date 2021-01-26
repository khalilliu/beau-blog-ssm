package com.khalil.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 博客介绍
 */
@Data
public class Options implements Serializable {
    private static final long serialVersionUID = -776792869602511933L;

    private Integer optionId;

    private String optionSiteTitle;

    private String optionSiteDescription;

    private String optionMetaDescription;

    private String optionMetaKeyword;

    private String optionAboutsiteAvatar;

    private String optionAboutsiteTitle;

    private String optionAboutsiteWechat;

    private String optionAboutsiteQq;

    private String optionAboutsiteGithub;

    private String optionAboutsiteWeibo;

    private String optionTongji;

    private Integer optionStatus;

}
