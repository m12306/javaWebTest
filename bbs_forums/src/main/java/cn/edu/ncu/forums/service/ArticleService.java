package cn.edu.ncu.forums.service;

import cn.edu.ncu.forums.dao.ArticleDao;
import cn.edu.ncu.forums.entity.Article;
import cn.edu.ncu.forums.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: Article的服务层
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 12:50
 * @version : 1.0
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 用户发表文章/需求
     * @param article 文章对象
     * @return 消息，1为状态码
     */
    public Message addArticle(Article article) {
        article.setCommentNumber(0L);
        article.setDislikedNumber(0L);
        article.setLikedNumber(0L);
        article.setCreatedTime(new Timestamp(new Date().getTime()));
        article.setPicked(false);
        article.setTop(false);//默认不置顶
        articleDao.save(article);
        return new Message(1, "success", article);
    }

    /**
     * 通过articleId获取文章内容
     * @param articleId 文章id
     * @return message
     */
    public Message getContent(Long articleId) {
        return new Message(1, "success", articleDao.findArticleById(articleId).getContent());
    }

    /**
     * 多表查询，查询对应文章的用户信息
     * @return message
     */
    public Message findAllUserArticle() {
        return new Message(1, "success", articleDao.findUserArticle());
    }

    /**
     * 查询所有文章，不分页
     * @return message
     */
    public Message findAll() {
        return new Message(1, "success", articleDao.findAll());
    }

    /**
     * 文章的分页查询
     * @param page 第几页
     * @param size 每一页多大
     * @return Message
     */
    public Message findBookPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "createdTime");
        List<Article> articles = new ArrayList<>();
        Page<Article> articlePage = articleDao.findAll(pageable);
        for (Article article: articlePage) {
            articles.add(article);
        }
        return new Message(1, "success", articles);
    }

    /**
     * 文章加精
     * @param picked 精选？
     * @param articleId 文章id
     * @return message
     */
    public Message updatePicked(Boolean picked, Long articleId) {
        articleDao.updatePickedById(picked, articleId);
        return new Message(1, "set picked success", 1);
    }

    /**
     * 修改内容

     * @return message
     */
    public Message updateArticle(Article art) {
        articleDao.saveAndFlush(art);
        return new Message(1, "modified content success", null);
    }

    /**
     * 用户或管理员删除文章
     * @param articleId 文章id
     * @return message
     */
    public Message delete(Long articleId) {
        articleDao.deleteById(articleId);
        return new Message(204, "delete success", null);
    }

    /**
     * 通过id查找文章
     * @param id 文章
     * @return message
     */
    public Message findById(Long id) {
        return new Message(1, "the article existed", articleDao.findArticleById(id));
    }

    /**
     * 文章置顶操作/取消置顶操作
     */
    public Message setIsTop(Article article) {
        articleDao.updateTop(article.getTop(), article.getId());
        return new Message(1, "success", null);
    }

    /**
     * 点赞
     */
    public Message like(Article article) {
        articleDao.updateLikedNumber(article.getLikedNumber() + 1, article.getId());
        return new Message(1, "like successfully", null);
    }

    /**
     * 取消点赞
     */
    public Message recoverLiked(Article article) {
        articleDao.updateLikedNumber(article.getLikedNumber() - 1, article.getId());
        return new Message(1, "recover successfully", null);
    }
}
