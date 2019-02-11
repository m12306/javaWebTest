package cn.edu.ncu.forums.dao;

import cn.edu.ncu.forums.entity.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: need层的dao，封装数据库操作
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/21 20:45
 * @version : 1.0
 */
@Repository
public interface NeedDao extends JpaRepository<Need, Long>, JpaSpecificationExecutor<Need> {

    /**
     * 通过需求的id删除需求
     * @param needId 需求的id
     */
    @Transactional
    void deleteById(Long needId);

}
