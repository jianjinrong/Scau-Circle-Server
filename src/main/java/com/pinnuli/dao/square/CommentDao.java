package com.pinnuli.dao.square;

import com.pinnuli.model.square.Comment;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-28
 */

public interface CommentDao {

    Integer saveComment(Comment comment);

    Integer deleteComment(int commentId);

    List<Comment> listCommentByPage(Map<String, Object> parameter);
}
