package cn.edu.ncu.forums.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Description: 评论的回复实体类
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:46
 * @version : 1.0
 */
@Entity
public class Reversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long commentId;//回复的评论的id

    @Column(nullable = false)
    private Timestamp reversionTime;//回复时间

    @Column(nullable = false)
    private Long userId;//用户的id

    @Column(nullable = false)
    private String content;//回复内容

    private Long reversionId;//评论的回复的回复

    private Boolean bool;

    private String string;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Timestamp getReversionTime() {
        return reversionTime;
    }

    public void setReversionTime(Timestamp reversionTime) {
        this.reversionTime = reversionTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReversionId() {
        return reversionId;
    }

    public void setReversionId(Long reversionId) {
        this.reversionId = reversionId;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Reversion{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", reversionTime=" + reversionTime +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }
}
