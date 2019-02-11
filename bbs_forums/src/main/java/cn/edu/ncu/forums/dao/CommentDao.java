package cn.edu.ncu.forums.dao;

import cn.edu.ncu.forums.entity.Comment;
import cn.edu.ncu.forums.multiple.CommentWithUsername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:51
 * @version : 1.0
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

    Comment findCommentById(Long id);

    /**
     * 通过文章id查询所有评论
     * @param articleId 文章id
     * @return 评论列表
     */
    List<Comment> findAllByArticleId(Long articleId);

    /**
     * 通过评论的id删除评论
     * @param id 评论id
     */
    void deleteById(Long id);

    /**
     * 通过文章id删除对应的所有评论
     * @param articleId 文章id
     */
    void deleteAllByArticleId(Long articleId);

    /**
     * 多表查询带有用户名的评论
     */
    @Modifying
    @Query(value = "select a.username as username, b.id as id, b.article_id as articleId," +
            " b.user_id as userId, b.comment_time as commentTime, b.content as content, " +
            "b.reversion_number as reversionNumber from user a, comment b where b.article_id = ?1 " +
            "and b.user_id = a.id", nativeQuery = true)
    List<CommentWithUsername> findAllCWUByArticleId(Long articleId);

    @Transactional
    @Modifying
    @Query("update Comment set reversionNumber = ?1 where id = ?2")
    void updateCommentNumber(Long reversionNumber, Long id);
}
