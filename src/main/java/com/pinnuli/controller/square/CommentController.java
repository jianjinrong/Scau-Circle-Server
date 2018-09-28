package com.pinnuli.controller.square;

import com.pinnuli.commons.Result;
import com.pinnuli.model.square.Comment;
import com.pinnuli.service.square.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-28
 */
@RestController
@RequestMapping("/api/square/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result deleteComment(@RequestParam Integer commentId) {
        return commentService.deleteComment(commentId);
    }
}
