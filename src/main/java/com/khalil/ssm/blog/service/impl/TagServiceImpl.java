package com.khalil.ssm.blog.service.impl;

import com.khalil.ssm.blog.entity.Tag;
import com.khalil.ssm.blog.mapper.ArticleTagRefMapper;
import com.khalil.ssm.blog.mapper.TagMapper;
import com.khalil.ssm.blog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;

    @Override
    public Integer countTag() {
        return null;
    }

    @Override
    public List<Tag> listTag() {
        return null;
    }

    @Override
    public List<Tag> listTagWithCount() {
        return null;
    }

    @Override
    public Tag getTagById(Integer id) {
        return null;
    }

    @Override
    public Tag insertTag(Tag tag) {
        return null;
    }

    @Override
    public void updateTag(Tag tag) {

    }

    @Override
    public void deleteTag(Integer id) {

    }

    @Override
    public Tag getTagByName(String name) {
        return null;
    }

    @Override
    public List<Tag> listTagByArticleId(Integer articleId) {
        return null;
    }
}
