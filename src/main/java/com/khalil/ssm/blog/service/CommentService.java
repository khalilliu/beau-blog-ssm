package com.khalil.ssm.blog.service;


import com.github.pagehelper.PageInfo;
import com.khalil.ssm.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 添加评论
     *
     * @param comment 评论
     */
    void insertComment(Comment comment);

    /**
     * 根据文章id获取评论列表
     *
     * @param articleId 文章ID
     * @return 列表
     */
    List<Comment> listCommentByArticleId(Integer articleId);

    /**
     * 根据id获取评论
     *
     * @param commentId
     * @return
     */
    Comment getCommentById(Integer commentId);

    /**
     * 获取所有评论列表
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示数量
     * @return 列表
     */
    PageInfo<Comment> listCommentByPage(Integer pageIndex, Integer pageSize);

    /**
     * 获得评论列表
     *
     * @return 列表
     */
    List<Comment> listComment();

    /**
     * 删除评论
     *
     * @param commentId ID
     */
    void deleteComment(Integer commentId);

    /**
     * 修改评论
     *
     * @param comment 评论
     */
    void updateComment(Comment comment);

    /**
     * 统计评论数
     *
     * @return 数量
     */
    Integer countComment();

    /**
     * 获得最近评论
     *
     * @param limit 查询数量
     * @return 列表
     */
    List<Comment> listRecentComment(Integer limit);

    /**
     * 获得评论的子评论
     *
     * @param commentId 评论ID
     * @return 列表
     */
    List<Comment> listChildComment(Integer commentId);


}
