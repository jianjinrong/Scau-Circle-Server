package com.pinnuli.service.square;

import com.pinnuli.commons.Result;
import com.pinnuli.model.square.Comment;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-28
 */
public interface CommentService {
    Result saveComment(Comment comment);

    Result deleteComment(int comemntId);
}
