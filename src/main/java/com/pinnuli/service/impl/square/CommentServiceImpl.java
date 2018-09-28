package com.pinnuli.service.impl.square;

import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.dao.square.CommentDao;
import com.pinnuli.model.square.Comment;
import com.pinnuli.service.square.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-28
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Result saveComment(Comment comment) {
        int saveResult = commentDao.saveComment(comment);
        if(saveResult > 0) {
            return Result.createBySuccess();
        } else {
            return Result.createByErrorCodeEnum(ErrorCodeEnum.DB_EXCEPTION);
        }
    }

    @Override
    public Result deleteComment(int comemntId) {
        int deleteResult = commentDao.deleteComment(comemntId);
        if(deleteResult > 0) {
            return Result.createBySuccess();
        } else {
            return Result.createByErrorCodeEnum(ErrorCodeEnum.DB_EXCEPTION);
        }
    }
}
