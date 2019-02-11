package cn.edu.ncu.forums.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Description: 文章实体类
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:46
 * @version : 1.0
 */
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String title;

    @Column(length = 40, nullable = false)
    private String subTitle;

    @Column(nullable = false)
    private Boolean isTop;//是否为置顶

    @Lob
    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private Timestamp createdTime;

    @Column(nullable = false)
    private Long userId;

    private Boolean picked;//精选

    @Column(nullable = false)
    private Long likedNumber;//点赞数

    @Column(nullable = false)
    private Long dislikedNumber;//踩数

    @Column(nullable = false)
    private Long commentNumber;//评论数

    @Column(length = 20, nullable = false)
    private String tag;//标签，记录文章的类别

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLikedNumber() {
        return likedNumber;
    }

    public void setLikedNumber(Long likedNumber) {
        this.likedNumber = likedNumber;
    }

    public Long getDislikedNumber() {
        return dislikedNumber;
    }

    public void setDislikedNumber(Long dislikedNumber) {
        this.dislikedNumber = dislikedNumber;
    }

    public Long getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Long commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getPicked() {
        return picked;
    }

    public void setPicked(Boolean picked) {
        this.picked = picked;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", isTop=" + isTop +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", userId=" + userId +
                ", picked=" + picked +
                ", likedNumber=" + likedNumber +
                ", dislikedNumber=" + dislikedNumber +
                ", commentNumber=" + commentNumber +
                ", tag='" + tag + '\'' +
                '}';
    }
}
