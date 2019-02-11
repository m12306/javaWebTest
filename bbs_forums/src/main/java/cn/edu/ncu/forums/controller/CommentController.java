package cn.edu.ncu.forums.controller;

import cn.edu.ncu.forums.entity.Comment;
import cn.edu.ncu.forums.service.CommentService;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description: comment的api
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 16:31
 * @version : 1.0
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 根据文章的id查询所有对应的评论
     * utl: localhost:8090/comment/addComment
     * @param articleId 文章id
     * @return message
     */
    @GetMapping("/getAll")
    @ResponseBody
    public Message getAllComments(@RequestParam ("articleId") Long articleId) {
        return commentService.getAllCWUByArticleId(articleId);
    }

    /**
     * 做评论
     * url: localhost:8090/comment/addComment
     * @param comment 评论
     * @return message
     */
    @PostMapping("/addComment")
    @ResponseBody
    public Message addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    /**
     * 删除某条评论
     * @param  commentId 评论的id
     * @return message
     */
    @PostMapping("/deleteComment")
    @ResponseBody
    public Message deleteComment(Long commentId) {
        return commentService.deleteComment(commentId);
    }

    /**
     * 删除某篇文章的所有评论
     * url: localhost:8090/comment/deleteAll
     * @param articleId 文章id
     */
    @PostMapping("/deleteAll")
    @ResponseBody
    public Message deleteAllComments(Long articleId) {
        return commentService.deleteAllComment(articleId);
    }

    @GetMapping("/getMapCR")
    @ResponseBody
    public Message getMapCR(@RequestParam ("articleId") Long articleId) {
        return commentService.getMapCR(articleId);
    }
}
