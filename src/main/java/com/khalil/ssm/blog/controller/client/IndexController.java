package com.khalil.ssm.blog.controller.client;

import com.github.pagehelper.PageInfo;
import com.khalil.ssm.blog.entity.Article;
import com.khalil.ssm.blog.entity.Tag;
import com.khalil.ssm.blog.enums.ArticleStatus;
import com.khalil.ssm.blog.service.ArticleService;
import com.khalil.ssm.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = {"/", "/article"})
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageIndex, @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        HashMap<String, Object> criteria = new HashMap<>(1);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        // 文章列表
        PageInfo<Article> articleList = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articleList);
        //公告
        //侧边栏
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("allTagList", tagList);

        // 最新评论
        model.addAttribute("pageUrlPrefix", "/article?pageIndex");
        return "Home/index";
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam("keywords") String keywords, @RequestParam(required = false, defaultValue = "1") Integer pageIndex, @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        // 文章列表
        HashMap<String, Object> criteria = new HashMap<>(1);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        criteria.put("keywords", keywords);
        PageInfo<Article> articleList = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articleList);

        //侧边栏显示
        //标签列表
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("allTagList", tagList);
        //获取随机文章
        List<Article> listRandomArticle = articleService.listRandomArticle(8);
        model.addAttribute("randomArticleList", listRandomArticle);
        //获取热评文章
        List<Article> listArticleByCommentCount = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", listArticleByCommentCount);


        model.addAttribute("pageUrlPrefix", "/search?pageIndex");

        return "Home/Page/search";
    }

    @RequestMapping("/404")
    public String NotFound(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "Home/Error/404";
    }

    @RequestMapping("/500")
    public String ServerError(@RequestParam(required = false) String message, Model model) {
        model.addAttribute("message", message);
        return "Home/Error/500";
    }

}
