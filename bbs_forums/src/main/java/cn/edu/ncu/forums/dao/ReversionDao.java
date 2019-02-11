package cn.edu.ncu.forums.dao;

import cn.edu.ncu.forums.entity.Reversion;
import cn.edu.ncu.forums.multiple.ReversionWithUsername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: reversion的dao层，封装数据库操作
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:51
 * @version : 1.0
 */
@Repository
public interface ReversionDao extends JpaRepository<Reversion, Long> {

    /**
     * 通过commentId查询回复
     * @param commentId 评论的id
     * @return 回复列表
     */
    List<Reversion> findReversionsByCommentId(Long commentId);

    /**
     * 通过reversionId删除评论
     * @param reversionId 回复的id
     */
    @Transactional
    void deleteById(Long reversionId);

    /**
     * 通过commentId删除所有回复
     * @param commentId 评论id
     */
    @Transactional
    void deleteReversionsByCommentId(Long commentId);

    @Transactional
    @Modifying
    @Query(value = "select a.username as username, b.id as id, b.comment_id as commentId, b.bool as bool, b.string as reversionUsername, " +
            "b.reversion_time as reversionTime, b.user_id as userId, b.content as content, b.reversion_id as reversionId " +
            "from User a, reversion b, reversion c, user d where b.comment_id = ?1  and a.id = b.user_id and b.reversion_id is null " +
            "union " +
            "select a.username as username, b.id as id, b.comment_id as commentId, b.bool as bool, d.username as reversionUsername, " +
            "b.reversion_time as reversionTime, b.user_id as userId, b.content as content, b.reversion_id as reversionId " +
            "from User a, reversion b, reversion c, user d where b.comment_id = ?1 and a.id = b.user_id and b.reversion_id is not null " +
            "and b.reversion_id = c.id and c.user_id = d.id", nativeQuery = true)
    List<ReversionWithUsername> findAllRWU(Long commentId);

    @Transactional
    @Query(value = "select a.username as username, b.id as id, b.comment_id as commentId, b.bool as bool, " +
            "b.reversion_time as reversionTime, b.user_id as userId, b.content as content, b.reversion_id as reversionId " +
            "from User a, reversion b, User c where b.id = ?1 and a.id = b.user_id and b.reversion_id is null", nativeQuery = true)
    ReversionWithUsername findRWUById(Long id);
}
