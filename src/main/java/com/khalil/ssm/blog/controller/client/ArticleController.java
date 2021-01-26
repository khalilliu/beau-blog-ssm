package com.khalil.ssm.blog.controller.client;

import com.alibaba.fastjson.JSON;
import com.khalil.ssm.blog.entity.Article;
import com.khalil.ssm.blog.entity.Tag;
import com.khalil.ssm.blog.entity.User;
import com.khalil.ssm.blog.enums.ArticleStatus;
import com.khalil.ssm.blog.service.ArticleService;
import com.khalil.ssm.blog.service.CategoryService;
import com.khalil.ssm.blog.service.TagService;
import com.khalil.ssm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/article/{articleId}")
    public String getArticleDetailPage(@PathVariable("articleId") Integer articleId, Model model) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), articleId);
        if(article == null) {
            return "Home/Error/404";
        }
        // 用户信息
        User user = userService.getUserById(article.getArticleUserId());
        article.setUser(user);

        // 文章信息
        model.addAttribute("article", article);

        // 相关文章
        List<Integer> categoryIds = articleService.listCategoryIdByArticleId(articleId);
        List<Article> similarArticleList = articleService.listArticleByCategoryIds(categoryIds, 5);
        model.addAttribute("similarArticleList", similarArticleList);

        //猜你喜欢
        List<Article> mostViewArticleList = articleService.listArticleByViewCount(5);
        model.addAttribute("mostViewArticleList", mostViewArticleList);

        //获取下一篇文章
        Article afterArticle = articleService.getAfterArticle(articleId);
        //获取上一篇文章
        Article preArticle = articleService.getPreArticle(articleId);
        model.addAttribute("afterArticle", afterArticle);
        model.addAttribute("preArticle", preArticle);

        //侧边栏
        //标签列表显示
        List<Tag> allTagList = tagService.listTag();
        model.addAttribute("allTagList", allTagList);
        //获取随机文章
        List<Article> listRandomArticle = articleService.listRandomArticle(8);
        model.addAttribute("randomArticleList", listRandomArticle);
        //获取热评文章
        List<Article> listArticleByCommentCount = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", listArticleByCommentCount);

        return "Home/Page/articleDetail";
    }

    /**
     * 点赞增加
     *
     * @param id 文章ID
     * @return 点赞量数量
     */
    @RequestMapping(value = "/article/like/{id}", method = {RequestMethod.POST}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String increaseLikeCount(@PathVariable("id") Integer id){
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleLikeCount = article.getArticleLikeCount();
        article.setArticleLikeCount(articleLikeCount+1);
        articleService.updateArticle(article);
        return JSON.toJSONString(articleLikeCount);
    }

    /**
     * 文章访问量数增加
     *
     * @param id 文章ID
     * @return 访问量数量
     */
    @RequestMapping(value = "/article/view/{id}", method = {RequestMethod.POST}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String increaseViewCount(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleViewCount = article.getArticleViewCount();
        article.setArticleViewCount(articleViewCount+1);
        articleService.updateArticle(article);
        return JSON.toJSONString(articleViewCount);
    }
}
