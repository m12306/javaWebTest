package cn.edu.ncu.forums.service;

import cn.edu.ncu.forums.dao.CommentDao;
import cn.edu.ncu.forums.dao.ReversionDao;
import cn.edu.ncu.forums.entity.Comment;
import cn.edu.ncu.forums.entity.Reversion;
import cn.edu.ncu.forums.multiple.ReversionWithUsername;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Description: reversion的服务层
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 22:28
 * @version : 1.0
 */
@Service
public class ReversionService {

    @Autowired
    private ReversionDao reversionDao;

    @Autowired
    private CommentDao commentDao;

    /**
     * 添加评论的回复
     * @param reversion 评论回复对象
     * @return 返回消息
     */
    public Message addReversion(Reversion reversion) {
        reversion.setReversionTime(new Timestamp(new Date().getTime()));
        reversion.setBool(false);
        Comment comment = commentDao.findCommentById(reversion.getCommentId());
        commentDao.updateCommentNumber(comment.getReversionNumber() + 1, comment.getId());
        reversionDao.save(reversion);
        return new Message(1, "add success", reversion);
    }

    /**
     * 通过评论id查询对应的所有回复
     * @param commentId 评论的id
     * @return 返回消息
     */
    public Message findByCommentId(Long commentId) {
        return new Message(1, "success", reversionDao.findReversionsByCommentId(commentId));
    }

    /**
     * 通过回复的id删除回复
     * @param reversionId 回复的id
     * @return message
     */
    public Message delete(Long reversionId) {
        reversionDao.deleteById(reversionId);
        return new Message(1, "modify success", null);
    }

    /**
     * 通过评论id查询所有的回复
     * @param commentId 评论的id
     * @return message
     */
    public Message getAllRWUByCommentId(Long commentId) {
        return new Message(1, "query successfully", reversionDao.findAllRWU(commentId));
    }

    /**
     * 通过id查找评论的回复
     * @param id
     * @return
     */
    public Message getRWUById(Long id) {
        return new Message(1, "query successfully", reversionDao.findRWUById(id));
    }
}
