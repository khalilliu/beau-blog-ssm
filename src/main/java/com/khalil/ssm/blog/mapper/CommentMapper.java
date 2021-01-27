package com.khalil.ssm.blog.mapper;

import com.khalil.ssm.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 根据ID删除
     *
     * @param commentId 评论ID
     * @return 影响行数
     */
    int deleteById(Integer commentId);

    /**
     * 添加
     *
     * @param comment 评论
     * @return 影响行数
     */
    int insert(Comment comment);

    Comment getCommentById(Integer commentId);

    int update(Comment comment);

    List<Comment> listCommentByArticleId(@Param(value = "id") Integer id); // 动态sql

    List<Comment> listComment();

    Integer countComment();

    List<Comment> listRecentComment(Integer limit);

    List<Comment> listChildComment(@Param(value = "id") Integer id);
}
