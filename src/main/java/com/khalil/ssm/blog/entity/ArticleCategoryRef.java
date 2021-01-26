package com.khalil.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *  文章与分类关联
 */
@Data
public class ArticleCategoryRef implements Serializable {
    private static final long serialVersionUID = -6809206515467725995L;

    private Integer articleId;

    private Integer categoryId;

    public ArticleCategoryRef() {
    }

    public ArticleCategoryRef(Integer articleId, Integer categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }
}
