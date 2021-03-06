package com.khalil.ssm.blog.service;

import com.khalil.ssm.blog.BaseTest;
import com.khalil.ssm.blog.entity.Article;
import com.khalil.ssm.blog.enums.ArticleStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class ArticleServiceTest extends BaseTest {
    @Autowired
    private ArticleService articleService;


    @Test
    public void countArticle() {
        int count = articleService.countArticle(ArticleStatus.PUBLISH.getValue());
        System.out.println(count);
        Assert.state(count > 0, "已发布文章数量为0");
    }

    @Test
    public void listRecentArticle() {
        List<Article> articleList = articleService.listRecentArticle(5);
        Assert.notEmpty(articleList, "文章数量为0");
    }
}
