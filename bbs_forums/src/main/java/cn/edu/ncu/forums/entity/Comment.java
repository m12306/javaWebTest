package cn.edu.ncu.forums.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Description: 评论实体类
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:46
 * @version : 1.0
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long articleId;//评论对应的文章的

    @Column(nullable = false)
    private Long userId;//评论所属用户

    @Column(nullable = false)

    private Timestamp commentTime;//评论时间
    @Column(nullable = false)
    private String content;//评论内容

    @Column(nullable = false)
    private Long reversionNumber;//回复数

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReversionNumber() {
        return reversionNumber;
    }

    public void setReversionNumber(Long reversionNumber) {
        this.reversionNumber = reversionNumber;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                ", reversionNumber=" + reversionNumber +
                '}';
    }
}
