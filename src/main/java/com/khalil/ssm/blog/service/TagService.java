package com.khalil.ssm.blog.service;

import com.khalil.ssm.blog.entity.Tag;

import java.util.List;

public interface TagService {

    /**
     * 获得标签总数
     * @return
     */
    Integer countTag();

    /**
     * 获得标签列表
     * @return
     */
    List<Tag> listTag();

    /**
     * 获得标签列表
     * @return
     */
    List<Tag> listTagWithCount();

    /**
     * 根据id获得标签信息
     * @param id 标签ID
     * @return 标签
     */
    Tag getTagById(Integer id);

    /**
     * 添加标签
     * @param tag 标签
     * @return
     */
    Tag insertTag(Tag tag);

    /**
     * 更新标签
     * @param tag 标签
     * @return
     */
    void updateTag(Tag tag);

    /**
     * 删除标签
     * @param id 标签ID
     * @return
     */
    void deleteTag(Integer id);

    /**
     * 根据标签名获取标签
     * @param name 标签名称
     * @return 标签
     */
    Tag getTagByName(String name);

    /**
     * 根据文章ID获得标签
     * @param articleId 文章ID
     * @return 标签列表
     */
    List<Tag> listTagByArticleId(Integer articleId);
}
