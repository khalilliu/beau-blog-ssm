package com.khalil.ssm.blog.mapper;

import com.khalil.ssm.blog.entity.ArticleCategoryRef;
import com.khalil.ssm.blog.entity.ArticleTagRef;
import com.khalil.ssm.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleTagRefMapper {
    /**
     * 添加文章和标签的关联记录
     * @param record 关联对象
     * @return 影响行数
     */
    int insert(ArticleTagRef record);

    /**
     * 根据标签Id删除记录
     * @param tagId
     * @return 影响行数
     */
    int deleteByTagId(Integer tagId);

    /**
     * 根据文章Id删除记录
     * @param articleId
     * @return 影响行数
     */
    int deleteByArticleId(Integer articleId);

    /**
     *  根据标签ID统计文章数量
     * @param tagId
     * @return 文章数量
     */
    int countArticleByTagId(Integer tagId);

    /**
     * 根据文章获取标签列表
     * @param articleId 文章Id
     * @return 标签列表
     */
    List<Tag> listTagByArticleId(Integer articleId);
}
