package cn.edu.ncu.forums.multiple;

import java.sql.Timestamp;

/**
 * Description:多表查询定义的接口，返回
 * 用户名、用户id、用户头像、文章id、文章标题、文章副标题、精选与否、评论数、点赞数、踩数
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/23 22:58
 * @version : 1.0
 */
public interface UserArticle {
    String getUsername();
    String getImage();
    String getAuthority();
    Timestamp getCreatedTime();
    Long getArticleId();
    String getTitle();
    String getSubTitle();
    Boolean getPicked();
    Long getCommentNum();
    Long getLikeNum();
    Long getDislikeNum();
    String getTag();
    Boolean getTop();
}
