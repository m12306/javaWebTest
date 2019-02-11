package cn.edu.ncu.forums.service;

import cn.edu.ncu.forums.dao.ArticleDao;
import cn.edu.ncu.forums.dao.CommentDao;
import cn.edu.ncu.forums.dao.ReversionDao;
import cn.edu.ncu.forums.dao.UserDao;
import cn.edu.ncu.forums.entity.Article;
import cn.edu.ncu.forums.entity.Comment;
import cn.edu.ncu.forums.multiple.CommentWithUsername;
import cn.edu.ncu.forums.multiple.ReversionWithUsername;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: comment的服务层
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 15:52
 * @version : 1.0
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ReversionDao reversionDao;

    @Autowired
    private ArticleDao articleDao;

    /**
     * 用户做评论
     * @param comment 评论
     * @return 消息
     */
    public Message addComment(Comment comment) {
        comment.setCommentTime(new Timestamp(new Date().getTime()));
        comment.setReversionNumber(0L);
        commentDao.save(comment);
        Article article = articleDao.findArticleById(comment.getArticleId());
        articleDao.updateCommentNumber(article.getCommentNumber() + 1, article.getId());
        return new Message(1, "success", comment);
    }

    /**
     * 根据文章id查询所有评论
     * @param articleId 文章的id
     * @return 消息
     */
    public Message findAllCommentsById(Long articleId) {
        List<Comment> comments = commentDao.findAllByArticleId(articleId);
        return new Message(1, "search success", comments);
    }

    /**
     * 通过id删除某条评论
     * @param commentId 评论的id
     * @return 状态消息
     */
    public Message deleteComment(Long commentId) {
        //删除对应的评论回复
        reversionDao.deleteReversionsByCommentId(commentId);
        commentDao.deleteById(commentId);
        return new Message(1, "delete success", null);
    }

    /**
     * 清空所有评论
     * @param articleId 文章的id
     * @return 状态消息
     */
    public Message deleteAllComment(Long articleId) {
        //删除对应文章的所有评论的回复
        List<Comment> comments = commentDao.findAllByArticleId(articleId);
        for (Comment comment: comments) {
            reversionDao.deleteReversionsByCommentId(comment.getId());
        }
        commentDao.deleteAllByArticleId(articleId);
        return new Message(1, "delete all comments success", null);
    }

    /**
     * 查询返回带有用户名的comment，根据articleId
     */
    public Message getAllCWUByArticleId(Long articleId) {
        return new Message(1, "success", commentDao.findAllCWUByArticleId(articleId));
    }

    public Message getMapCR(Long articleId) {
        List<CommentWithUsername> commentWithUsernames = commentDao.findAllCWUByArticleId(articleId);
        Map<CommentWithUsername, List<ReversionWithUsername>> map = new HashMap<>();
        for (CommentWithUsername commentWithUsername: commentWithUsernames) {
            System.out.println(commentWithUsername.toString());
            List<ReversionWithUsername> reversionWithUsernames = reversionDao.findAllRWU(commentWithUsername.getId());
            map.put(commentWithUsername, reversionWithUsernames);
        }
        return new Message(1, "success", map);
    }
}
