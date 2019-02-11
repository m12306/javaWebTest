package cn.edu.ncu.forums.multiple;

import java.sql.Timestamp;

/**
 * Description: 多表查询接口，带有username的评论回复
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/26 0:28
 * @version : 1.0
 */
public interface ReversionWithUsername {
    String getUsername();
    Long getId();
    Long getCommentId();
    Timestamp getReversionTime();
    Long getUserId();
    String getContent();
    Long getReversionId();
    Boolean getBool();
    String getReversionUsername();
}
