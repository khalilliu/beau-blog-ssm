package com.khalil.ssm.blog.controller.client;

import com.github.pagehelper.PageInfo;
import com.khalil.ssm.blog.entity.Article;
import com.khalil.ssm.blog.entity.Category;
import com.khalil.ssm.blog.entity.Tag;
import com.khalil.ssm.blog.enums.ArticleStatus;
import com.khalil.ssm.blog.service.ArticleService;
import com.khalil.ssm.blog.service.CategoryService;
import com.khalil.ssm.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/category/{cateId}")
    public String getArticleListByCategory(@PathVariable("cateId") Integer cateId,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                           Model model) {
        Category category = categoryService.getCategoryById(cateId);
        if (category == null) {
            return "redirect:/404";
        }
        model.addAttribute("category", category);

        HashMap<String, Object> criteria = new HashMap<>(2);
        criteria.put("categoryId", cateId);
        criteria.put("status", ArticleStatus.PUBLISH.getValue());
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);

        List<Tag> allTagList = tagService.listTag();
        model.addAttribute("allTagList", allTagList);
        //获得随机文章
        List<Article> randomArticleList = articleService.listRandomArticle(8);
        model.addAttribute("randomArticleList", randomArticleList);
        //获得热评文章
        List<Article> mostCommentArticleList = articleService.listArticleByCommentCount(8);
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);

        model.addAttribute("pageUrlPrefix", "/category/" + pageIndex + "?pageIndex");
        return "Home/Page/articleListByCategory";
    }
}
