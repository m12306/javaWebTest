package cn.edu.ncu.forums.multiple;

import java.sql.Timestamp;

/**
 * Description:多表查询接口定义
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/25 12:19
 * @version : 1.0
 */
public interface CommentWithUsername {
    String getUsername();
    Long getId();
    Long getArticleId();
    Long getUserId();
    Timestamp getCommentTime();
    String getContent();
    Long getReversionNumber();
}
