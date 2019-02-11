package cn.edu.ncu.forums.dao;

import cn.edu.ncu.forums.entity.Article;
import cn.edu.ncu.forums.multiple.UserArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: article的dao层，封装数据库操作
 *              1.通过id查询文章
 *              2.修改文章内容
 *              3.修改picked字段
 *              4.更新点赞数
 *              5.更新非点赞数
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:50
 * @version : 1.0
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

    /**
     * 通过id查询文章
     * @param id 文章id
     * @return 文章对象
     */
    Article findArticleById(Long id);

    /**
     * 修改文章内容
     * @param content 新的内容
     * @param articleId 文章id
     */
    @Transactional
    @Modifying
    @Query("update Article set content = ?1 where  id = ?2")
    void updateContentById(String content, Long articleId);

    /**
     * 将文章置为精选或非精选
     * @param picked 为true则是作为精选，为false则是作为普通
     * @param articleId 文章的id
     */
    @Transactional
    @Modifying
    @Query("update Article set picked = ?1 where id = ?2" )
    void updatePickedById(Boolean picked, Long articleId);

    /**
     * 更新点赞的数量
     * @param likes 点赞的数量
     * @param articleId 文章id
     */
    @Transactional
    @Modifying
    @Query("update Article set likedNumber = ?1 where id = ?2")
    void updateLikes(Long likes, Long articleId);

    /**
     * 更新踩的数量
     * @param dislikes 不喜欢的数量
     * @param articleId 文章id
     */
    @Transactional
    @Modifying
    @Query("update Article set dislikedNumber = ?1 where id = ?2")
    void updateDislikes(Long dislikes, Long articleId);

    /**
     * 通过id删除文章
     * @param id 文章id
     */
    @Transactional
    void deleteById(Long id);

    /**
     * 多表查询，查出某篇文章的
     * username，image，articleId，title，subtitle，createdTime, likeNum, dislikeNum, tag
     * @return 复杂类型
     */
    @Query(value = "select a.username as username, a.image as image, a.authority as authority, b.created_time as createdTime, " +
            "b.id as articleId, b.title as title, b.sub_title as subTitle, b.picked as picked, " +
            "b.comment_number as commentNum, " +
            "b.liked_number as likeNum, b.disliked_number as dislikeNum, b.tag as tag, b.is_top as top " +
            "from User a, Article b where a.id = b.user_id order by b.created_time desc", nativeQuery = true)
    List<UserArticle> findUserArticle();


    /**
     * 置顶操作/取消置顶操作
     */
    @Transactional
    @Modifying
    @Query("update Article set is_top = ?1 where id = ?2")
    void updateTop(Boolean isTop, Long id);

    /**
     * 更新评论数
     */
    @Transactional
    @Modifying
    @Query("update Article set commentNumber = ?1 where id = ?2")
    void updateCommentNumber(Long commentNumber, Long id);

    /**
     * 更新点赞数
     */
    @Transactional
    @Modifying
    @Query("update Article set likedNumber = ?1 where id = ?2")
    void updateLikedNumber(Long likedNumber, Long id);
}
